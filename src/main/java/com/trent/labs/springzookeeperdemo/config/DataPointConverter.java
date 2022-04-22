package com.trent.labs.springzookeeperdemo.config;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.trent.labs.springzookeeperdemo.DataPoint;
import lombok.SneakyThrows;

import java.beans.PropertyEditorSupport;
import java.util.Arrays;
import java.util.List;

public class DataPointConverter extends PropertyEditorSupport {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @SneakyThrows
    @Override
    public String getAsText() {
        List<DataPoint> dataPoints = (List<DataPoint>) this.getValue();
        return objectMapper.writeValueAsString(dataPoints);
    }

    @SneakyThrows
    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        System.out.println(text);
        List<DataPoint> dataPoint = Arrays.asList(objectMapper.readValue(text, DataPoint[].class));
        super.setValue(dataPoint);
    }

}
