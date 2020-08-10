package io.wegetit.shelby.commons.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.io.IOException;
import java.util.List;

@Slf4j
public class DataLoaderUtils {

    public static <T> void loadAllIfEmpty(MongoTemplate template, String file, Class<T> type) throws IOException {
        long count = template.getCollection(template.getCollectionName(type)).countDocuments();
        if (count == 0) {
            loadAll(template, file, type);
        } else {
            log.info("Skipped loading {} as it contains {} elements", type.getSimpleName(), count);
        }
    }

    public static <T> void loadAll(MongoTemplate template, String file, Class<T> type) throws IOException {
        long start = System.currentTimeMillis();
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        Resource resource = resolver.getResource("/changelogs/" + file);
        if (!resource.exists()) {
            throw new IllegalStateException(file + " not found in changelogs.");
        }
        ObjectMapper objectMapper = new ObjectMapper();
        List<T> data  =  objectMapper.readValue(resource.getURL(), objectMapper.getTypeFactory().constructCollectionType(List.class, type));
        data.stream().forEach(p -> {
            template.remove(p);
            template.save(p);
        });
        long end = System.currentTimeMillis();
        log.info("Loaded {} with {} elements in {} ms.", type.getSimpleName(), data.size(), (end - start));
    }
}
