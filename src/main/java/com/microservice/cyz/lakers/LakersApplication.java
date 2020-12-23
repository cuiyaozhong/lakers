package com.microservice.cyz.lakers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@ComponentScan("com.microservice.cyz")
@Configuration
@EnableSwagger2
@EnableTransactionManagement
@EnableAsync
public class LakersApplication {

    public static void main(String[] args) {
        SpringApplication.run(LakersApplication.class, args);
    }

}
