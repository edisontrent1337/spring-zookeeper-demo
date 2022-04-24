package com.trent.labs.springzookeeperdemo.config;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.trent.labs.springzookeeperdemo.DataPointMetaData;
import lombok.SneakyThrows;

import java.beans.PropertyEditorSupport;
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
        JavaType type = mapper.getTypeFactory().constructCollectionType(List.class, DataPointMetaData.Item.class);
        List<DataPointMetaData.Item> result = mapper.readValue(text, type);
        super.setValue(DataPointMetaData.builder().items(result).build());
    }

}

