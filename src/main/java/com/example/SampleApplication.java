package com.example;

import com.example.application.ApplicationBeans;
import com.example.framework.FrameworkBeans;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Import;

// no component scan magic, all beans are defined explicitly
@SpringBootConfiguration
@EnableAutoConfiguration
@Import({FrameworkBeans.class, ApplicationBeans.class})
public class SampleApplication {
    public static void main(String[] args) {
        SpringApplication.run(SampleApplication.class, args);
    }
}


