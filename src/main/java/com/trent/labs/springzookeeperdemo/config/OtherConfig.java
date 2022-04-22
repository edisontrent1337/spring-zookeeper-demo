package com.trent.labs.springzookeeperdemo.config;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.trent.labs.springzookeeperdemo.DataPoint;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RefreshScope
public class OtherConfig {
    @Value("${name}")
    private String dataPoint;
    @Bean
    public DataPoint dataPoint() throws JsonProcessingException {
        return new ObjectMapper().readValue(dataPoint, DataPoint.class);
    }
}
