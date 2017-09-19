package com.example.framework;

import org.springframework.context.annotation.Bean;
import org.springframework.web.filter.HiddenHttpMethodFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class FrameworkBeans {

    @Bean
    public GreetingController greetingController() {
        return new GreetingController();
    }


    // quick and dirty way to disable OrderedHiddenHttpMethodFilter that is setup by spring boot (see WebMvcAutoConfiguration).
    // we don't have it, we don't need it.
    @Bean
    public HiddenHttpMethodFilter hiddenHttpMethodFilter() {
        return new HiddenHttpMethodFilter() {
            @Override
            protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
                filterChain.doFilter(request, response); // do nothing
            }
        };
    }
}
