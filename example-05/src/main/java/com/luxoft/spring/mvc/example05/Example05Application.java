package com.luxoft.spring.mvc.example05;

import com.luxoft.spring.mvc.example05.config.Configuration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Import;

@SpringBootConfiguration                // Tells that this is Spring Boot application
@EnableAutoConfiguration
@Import(Configuration.class)            // Import our custom configuration
public class Example05Application {

    public static void main(String[] args) {
        SpringApplication.run(Example05Application.class, args);
    }
}
