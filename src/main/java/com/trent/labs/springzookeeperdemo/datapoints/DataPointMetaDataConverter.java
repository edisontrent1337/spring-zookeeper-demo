package com.trent.labs.springzookeeperdemo.datapoints;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;

import java.beans.PropertyEditorSupport;
import java.util.Arrays;
import java.util.List;

public class DataPointMetaDataConverter extends PropertyEditorSupport {

    private final ObjectMapper mapper = new ObjectMapper();

    @SneakyThrows
    @Override
    public String getAsText() {
        DataPointMetaData dataPoints = (DataPointMetaData) this.getValue();
        return mapper.writeValueAsString(dataPoints);
    }

    @SneakyThrows
    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        List<DataPointMetaData.Item> result = Arrays.asList(mapper.readValue(text, DataPointMetaData.Item[].class));
        super.setValue(DataPointMetaData.builder().items(result).build());
    }

}

