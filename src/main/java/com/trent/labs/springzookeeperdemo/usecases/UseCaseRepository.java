package com.trent.labs.springzookeeperdemo.usecases;

import org.springframework.cloud.zookeeper.config.ZookeeperPropertySource;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class UseCaseRepository {

    private static final String USE_CASE_PATH = "usecases.%s.%s";

    private final ConfigurableEnvironment environment;
    private final ZookeeperPropertySource zookeeperSource;

    public UseCaseRepository(ZookeeperPropertySource zookeeperSource, ConfigurableEnvironment environment) {
        this.environment = environment;
        this.zookeeperSource = zookeeperSource;
    }

    public UseCase getUseCase(String tenantId, String usecase) {
        return environment.getProperty(String.format(USE_CASE_PATH, tenantId, usecase), UseCase.class);
    }

    public List<UseCase> getUseCases(String tenantId) {
        return Arrays.stream(zookeeperSource.getPropertyNames())
                .filter(property -> property.startsWith("usecases." + tenantId))
                .map(property -> environment.getProperty(property, UseCase.class))
                .collect(Collectors.toList());
    }

}
