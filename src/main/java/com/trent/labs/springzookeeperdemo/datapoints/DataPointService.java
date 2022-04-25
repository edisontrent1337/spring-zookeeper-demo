package com.trent.labs.springzookeeperdemo.datapoints;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

@Component
@RefreshScope
public class DataPointService {

    @Value("${data.datapoints}")
    private DataPointMetaData dataPointMetaData;

    public String getDataPoints() {
        return "Hello " + this.dataPointMetaData.toString();
    }
}
