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

    public static <T> void loadAll(MongoTemplate template, String file, Class<T> type) throws IOException {
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
        log.info("Loaded {} with {} elements.", type.getSimpleName(), data.size());
    }
}
