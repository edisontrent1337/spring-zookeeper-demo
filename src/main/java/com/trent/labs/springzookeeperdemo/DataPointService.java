package com.trent.labs.springzookeeperdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.zookeeper.config.ZookeeperPropertySource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
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
