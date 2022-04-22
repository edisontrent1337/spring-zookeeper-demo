package com.trent.labs.springzookeeperdemo.config;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.trent.labs.springzookeeperdemo.DataPoint;
import com.trent.labs.springzookeeperdemo.DataPointMetaData;
import org.springframework.beans.PropertyEditorRegistrar;
import org.springframework.beans.PropertyEditorRegistry;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MyCustomEditorRegistrar implements PropertyEditorRegistrar {
    @Override
    public void registerCustomEditors(PropertyEditorRegistry registry) {
        ObjectMapper mapper = new ObjectMapper();
        JavaType type = mapper.getTypeFactory().constructCollectionType(List.class, DataPointMetaData.class);
        registry.registerCustomEditor(type.getRawClass(), new DataPointMetaDataConverter());
        //JavaType other = mapper.getTypeFactory().constructCollectionType(List.class, DataPoint.class);
        //registry.registerCustomEditor(other.getRawClass(), new DataPointConverter());
    }
}
