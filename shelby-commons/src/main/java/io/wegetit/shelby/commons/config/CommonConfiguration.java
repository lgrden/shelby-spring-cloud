package io.wegetit.shelby.commons.config;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.github.cloudyrock.mongock.Mongock;
import com.github.cloudyrock.mongock.SpringMongockBuilder;
import com.mongodb.MongoClient;
import com.mongodb.lang.NonNull;
import feign.codec.ErrorDecoder;
import io.wegetit.shelby.commons.config.error.ClientErrorDecoder;
import io.wegetit.shelby.commons.config.error.ExceptionType;
import io.wegetit.shelby.commons.config.error.GlobalExceptionHandler;
import io.wegetit.shelby.commons.exceptions.ClientErrorResponseException;
import io.wegetit.shelby.commons.exceptions.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.mongo.MongoProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.mongodb.core.convert.MongoCustomConversions;
import org.springframework.http.HttpStatus;

import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Configuration
@PropertySource("classpath:config.properties")
public class CommonConfiguration {

    @Bean
    public ObjectMapper getObjectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        objectMapper.configure(SerializationFeature.WRITE_EMPTY_JSON_ARRAYS, false);
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        return objectMapper;
    }

    @Bean
    public MongoCustomConversions mongoCustomConversions() {
        List<Converter> converters = new ArrayList<>();
        converters.add(new Converter<LocalDate, Date>() {
            @Override
            public Date convert(@NonNull LocalDate source) {
                return new Date(source.atStartOfDay().atZone(ZoneOffset.UTC).toInstant().toEpochMilli());
            }
        });
        converters.add(new Converter<Date, LocalDate>() {
            @Override
            public LocalDate convert(@NonNull Date source) {
                return source.toInstant().atZone(ZoneOffset.UTC).toLocalDate();
            }
        });
        return new MongoCustomConversions(converters);
    }

    @Bean
    @ConditionalOnProperty(value="changeLogScanPackage", matchIfMissing = false)
    public Mongock mongock(MongoProperties properties, MongoClient mongoClient, @Value("${changeLogScanPackage}") String changeLogScanPackage) {
        return new SpringMongockBuilder(mongoClient, properties.getDatabase(), changeLogScanPackage)
            .setLockQuickConfig()
            .setChangeLogCollectionName("dbchangelog")
            .build();
    }

    @Bean
    public GlobalExceptionHandler globalExceptionHandler() {
        GlobalExceptionHandler exceptionHandler = new GlobalExceptionHandler();
        exceptionHandler.registerType(ExceptionType.builder().errorClass(EntityNotFoundException.class).status(
            HttpStatus.NOT_FOUND).logException(false).build());
        exceptionHandler.registerType(ExceptionType.builder().errorClass(ClientErrorResponseException.class).status(
                HttpStatus.INTERNAL_SERVER_ERROR).logException(false).build());
        return exceptionHandler;
    }

    @Bean
    public ErrorDecoder errorDecoder(ObjectMapper mapper) {
        return new ClientErrorDecoder(mapper);
    }
}
