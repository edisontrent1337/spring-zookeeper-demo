package com.trent.labs.springzookeeperdemo.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.trent.labs.springzookeeperdemo.usecases.UseCase;
import lombok.SneakyThrows;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class UseCaseConverter implements Converter<String, UseCase> {
    @SneakyThrows
    @Override
    public UseCase convert(String source) {
        return new ObjectMapper().readValue(source, UseCase.class);
    }

}
