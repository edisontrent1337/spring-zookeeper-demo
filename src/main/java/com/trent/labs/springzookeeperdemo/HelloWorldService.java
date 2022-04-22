package com.trent.labs.springzookeeperdemo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RefreshScope
public class HelloWorldService {

    @Value("${name}")
    private List<DataPoint> dataPoint;

    @Value("${name}")
    private List<DataPointMetaData> dataPointMetaData;

    public String getHelloMessage() {
        return "Hello " + this.dataPointMetaData.toString();
    }
}
