package com.trent.labs.springzookeeperdemo.config;

import com.trent.labs.springzookeeperdemo.DataPointMetaData;
import org.springframework.beans.factory.config.CustomEditorConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import java.beans.PropertyEditor;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class SharedZookeeperConfiguration {
    @Bean
    public CustomEditorConfigurer customEditorConfigurer() {
        Map<Class<?>, Class<? extends PropertyEditor>> propertyEditors = new HashMap<>(1);
        propertyEditors.put(DataPointMetaData.class, DataPointMetaDataConverter.class);
        CustomEditorConfigurer configurer = new CustomEditorConfigurer();
        configurer.setCustomEditors(propertyEditors);
        return configurer;
    }
}
