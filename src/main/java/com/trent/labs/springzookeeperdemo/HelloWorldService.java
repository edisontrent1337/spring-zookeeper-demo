package com.trent.labs.springzookeeperdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

@Component
@RefreshScope
public class HelloWorldService {
   /* @Value("${name}")
    private DataPoint name; */

    @Autowired
    private DataPoint dataPoint;

    public String getHelloMessage() {
        return "Hello " + this.dataPoint;
    }
}
