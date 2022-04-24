package com.trent.labs.springzookeeperdemo;

import com.trent.labs.springzookeeperdemo.datapoints.DataPointService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
@EnableScheduling
@SpringBootApplication
public class SpringZookeeperDemoApplication {

    private static final Logger LOG = LoggerFactory.getLogger(SpringZookeeperDemoApplication.class);
    private final DataPointService dataPointService;

    public SpringZookeeperDemoApplication(DataPointService dataPointService) {
        this.dataPointService = dataPointService;
    }

    @Scheduled(fixedRate = 1000)
    public void run() {
        LOG.info(dataPointService.getDataPoints());
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringZookeeperDemoApplication.class, args);
    }
}