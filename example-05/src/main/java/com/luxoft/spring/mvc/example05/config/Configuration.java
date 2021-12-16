package com.luxoft.spring.mvc.example05.config;

import com.luxoft.spring.mvc.example05.domain.OrdersRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * This class contains beans definitions and Spring MVC configuration
 */
// TODO: try to do the same using basePackageClasses instead of basePackages
@ComponentScan(             // this annotation scans required package to create controller bean
        basePackages = "com.luxoft.spring.mvc.example05.controller"
)
@EnableWebMvc               // this enables Spring MVC framework
public class Configuration {

    @Bean
    public OrdersRepository repo() {
        return new OrdersRepository();
    }
}
