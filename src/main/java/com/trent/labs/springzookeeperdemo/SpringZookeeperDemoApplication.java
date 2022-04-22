package com.trent.labs.springzookeeperdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
@EnableScheduling
@SpringBootApplication
public class SpringZookeeperDemoApplication {
    private final HelloWorldService helloWorldService;

    public SpringZookeeperDemoApplication(HelloWorldService helloWorldService) {
        this.helloWorldService = helloWorldService;
    }

    @Scheduled(fixedRate = 1000)
    public void run() {
        System.out.println(this.helloWorldService.getHelloMessage());
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringZookeeperDemoApplication.class, args);
    }
}