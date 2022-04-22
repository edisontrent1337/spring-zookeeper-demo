package com.trent.labs.springzookeeperdemo.config;

import com.trent.labs.springzookeeperdemo.DataPoint;
import org.springframework.beans.factory.config.CustomEditorConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.beans.PropertyEditor;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Configuration
public class SharedZookeeperConfiguration {

    @Bean
    public CustomEditorConfigurer customEditorConfigurer() {

        Map<Class<?>, Class<? extends PropertyEditor>> propertyEditors = new HashMap<>(1);
        propertyEditors.put(List.class, DataPointConverter.class);

        CustomEditorConfigurer configurer = new CustomEditorConfigurer();
        //configurer.setCustomEditors(propertyEditors);
        configurer.setPropertyEditorRegistrars(new MyCustomEditorRegistrar[] {new MyCustomEditorRegistrar()});

        return configurer;
    }

}
