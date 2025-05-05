package com.server.starter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = {"com.server"})
@SpringBootApplication
public class SpringRestApiApplication {
    public static void main(String[] args){
        SpringApplication.run(SpringRestApiApplication.class, args);
    }
}