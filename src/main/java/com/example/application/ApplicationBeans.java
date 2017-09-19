package com.example.application;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationBeans {
    @Bean
    public CallbackController callbackController() {
        return new CallbackController();
    }
}
