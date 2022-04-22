package com.trent.labs.springzookeeperdemo.config;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.trent.labs.springzookeeperdemo.DataPoint;
import org.springframework.core.convert.converter.Converter;

public class DataPointConverter implements Converter<String, DataPoint> {

    @Override
    public DataPoint convert(String input) {
        try {
            return new ObjectMapper().readValue(input, DataPoint.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

}
