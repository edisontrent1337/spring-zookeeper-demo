package com.trent.labs.springzookeeperdemo.usecases;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class UseCaseConverter implements Converter<String, UseCase> {

    private final ObjectMapper mapper = new ObjectMapper();

    @SneakyThrows
    @Override
    public UseCase convert(String source) {
        return mapper.readValue(source, UseCase.class);
    }

}
