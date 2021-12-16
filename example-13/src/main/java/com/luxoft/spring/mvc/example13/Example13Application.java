package com.luxoft.spring.mvc.example13;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;

import java.util.Locale;

@SpringBootApplication                 // WebMvcConfigurerAdapter provides methods for interceptors
public class Example13Application extends WebMvcConfigurerAdapter {

    private final LocaleChangeInterceptor lci;

    @Autowired
    public Example13Application(LocaleChangeInterceptor lci) {
        this.lci = lci;
    }

    @Bean                                           // Gets current locale from browser cookie
    public LocaleResolver localeResolver() {
        CookieLocaleResolver resolver = new CookieLocaleResolver();
        resolver.setDefaultLocale(new Locale("en"));
        resolver.setCookieName("locale");
        return resolver;
    }

    @Bean
    public LocaleChangeInterceptor lci() {          // Allows you change locale
        LocaleChangeInterceptor lci = new LocaleChangeInterceptor();
        lci.setParamName("lang");
        return lci;
    }

    // TODO: open '/index?lang=fr'. What do yo see?

    @Override                                       // adding interceptor to Spring MVC
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(lci);
        super.addInterceptors(registry);
    }

    // TODO: comment this bean and see that Spring Boot provides this code

    @Bean
    public MessageSource messageSource() {
        ReloadableResourceBundleMessageSource ms = new ReloadableResourceBundleMessageSource();
        ms.setBasename("classpath:messages");       // means messages.properties, messages_fr.properties, etc.
        ms.setDefaultEncoding("UTF-8");
        return ms;
    }

    public static void main(String[] args) {
        SpringApplication.run(Example13Application.class, args);
    }
}
