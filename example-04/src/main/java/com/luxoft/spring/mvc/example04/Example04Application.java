package com.luxoft.spring.mvc.example04;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// @SpringBootApplication annotation scans all packages
// and creates beans with @Service and @Controller stereotypes
@SpringBootApplication
public class Example04Application {

    public static void main(String[] args) {
        SpringApplication.run(Example04Application.class, args);
    }
}
