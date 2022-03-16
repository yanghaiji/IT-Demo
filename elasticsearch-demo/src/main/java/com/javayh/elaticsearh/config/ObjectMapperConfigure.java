package com.javayh.elaticsearh.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import org.elasticsearch.search.aggregations.bucket.terms.ParsedStringTerms;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * <p>
 * es 聚合后json 序列化
 * </p>
 *
 * @author hai ji
 * @version 1.0.0
 * @since 2022/2/10
 */
@Configuration
public class ObjectMapperConfigure {
    @Bean
    public ObjectMapper objectMapper() {

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(simpleModule());
        return objectMapper;
    }

    private SimpleModule simpleModule() {
        ParsedStringTermsBucketSerializer serializer = new ParsedStringTermsBucketSerializer(ParsedStringTerms.ParsedBucket.class);
        SimpleModule module = new SimpleModule();
        module.addSerializer(serializer);
        return module;
    }
}
