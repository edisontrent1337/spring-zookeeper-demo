package com.trent.labs.springzookeeperdemo.usecases;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.bind.Binder;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.zookeeper.config.ZookeeperPropertySource;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.support.ConfigurableConversionService;
import org.springframework.core.env.AbstractEnvironment;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.PropertySource;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Component
@RefreshScope
public class UseCaseRepository {

    private final ConfigurableEnvironment environment;
    private final ZookeeperPropertySource zookeeperPropertySource;

    public UseCaseRepository(ConversionService conversionService, ConfigurableEnvironment environment) {
        this.environment = environment;
        environment.setConversionService((ConfigurableConversionService) conversionService);
        this.zookeeperPropertySource = (ZookeeperPropertySource) environment.getPropertySources()
                .stream()
                .filter(z -> z.getName().equals("config/exve"))
                .findFirst().orElseThrow(IllegalStateException::new);
    }

    public UseCase getUseCase(String tenantId, String usecase) {
        return environment.getProperty("usecases." + tenantId + "." + usecase, UseCase.class);
    }

    public List<UseCase> getUseCases(String tenantId) {
        return Arrays.stream(zookeeperPropertySource.getPropertyNames())
                        .filter(p -> p.startsWith("usecases." + tenantId))
                        .map(s -> environment.getProperty(s, UseCase.class))
                        .collect(Collectors.toList());
    }
}
