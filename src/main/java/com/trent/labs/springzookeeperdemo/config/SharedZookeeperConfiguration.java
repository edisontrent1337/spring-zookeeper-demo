package com.trent.labs.springzookeeperdemo.config;

import com.trent.labs.springzookeeperdemo.datapoints.DataPointMetaData;
import com.trent.labs.springzookeeperdemo.datapoints.DataPointMetaDataConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.CustomEditorConfigurer;
import org.springframework.cloud.zookeeper.config.ZookeeperPropertySource;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.support.ConfigurableConversionService;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.web.bind.annotation.PathVariable;

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

    @Bean
    public ZookeeperPropertySource zookeeperPropertySource(
            ConfigurableEnvironment environment,
            ConfigurableConversionService conversionService,
            @Value("${spring.cloud.zookeeper.config.name}") String configurationName,
            @Value("${spring.cloud.zookeeper.config.root}") String configurationRoot
    ) {
        environment.setConversionService(conversionService);
        return (ZookeeperPropertySource) environment.getPropertySources()
                .stream()
                .filter(z -> z.getName().equals(configurationRoot + "/" + configurationName))
                .findFirst()
                .orElseThrow(IllegalStateException::new);
    }
}
