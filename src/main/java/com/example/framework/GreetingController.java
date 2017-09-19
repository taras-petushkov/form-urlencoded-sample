package com.example.framework;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    @RequestMapping(value = "/hello", params = "name")
    public String helloWithName(@RequestParam String name) {
        return sayHelloTo(name);
    }

    @RequestMapping(value = "/hello", params = "!name")
    public String helloWithNoName() {
        return sayHelloTo("World");
    }

    private String sayHelloTo(String name) {
        return "Hello " + name + "!";
    }
}
