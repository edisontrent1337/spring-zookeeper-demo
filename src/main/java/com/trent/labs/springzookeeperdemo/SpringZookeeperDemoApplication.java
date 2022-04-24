package com.trent.labs.springzookeeperdemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.AbstractEnvironment;
import org.springframework.core.env.Environment;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
@EnableScheduling
@SpringBootApplication
public class SpringZookeeperDemoApplication {

    private static final Logger LOG = LoggerFactory.getLogger(SpringZookeeperDemoApplication.class);
    private final DataPointService dataPointService;

    @Autowired
    private Environment environment;

    @Autowired
    private ApplicationContext context;

    public SpringZookeeperDemoApplication(DataPointService dataPointService) {
        this.dataPointService = dataPointService;
    }

    @Scheduled(fixedRate = 1000)
    public void run() {
        // LOG.info(this.helloWorldService.getHelloMessage());
        AbstractEnvironment e = (AbstractEnvironment) environment;
        // LOG.info(environment.getProperty("usecases.234567891-DEUGRPA.payasyoudrive"));
       /* for (PropertySource<?> propertySource : e.getPropertySources().stream().filter(ZookeeperPropertySource.class::isInstance).collect(Collectors.toList())) {
            for (String propertyName : ((ZookeeperPropertySource) propertySource).getPropertyNames()) {
                if (propertyName.startsWith("usecases")) {
                    LOG.info(e.getProperty(propertyName));
                }
            }
        }

        ConversionService service = context.getBean(ConfigurableConversionService.class);
        System.out.println("CONTEXT");
        System.out.println(service);

        System.out.println("ENVIRONMENT");
        System.out.println(e.getConversionService());*/
       // e.setConversionService((ConfigurableConversionService) service);
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringZookeeperDemoApplication.class, args);
    }
}