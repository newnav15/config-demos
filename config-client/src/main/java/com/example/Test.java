package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.art.platform.config.Service;
import com.art.platform.config.ServiceConfiguration;




@SpringBootApplication
@Import(ServiceConfiguration.class)
@RestController
public class Test {

    private final Service service;

    @Autowired
    public Test(Service service) {
        this.service = service;
    }

    @GetMapping("/")
    public String home() {
    	System.out.println("..............................................."+service.message());
        return service.message();
    }

    public static void main(String[] args) {
        SpringApplication.run(Test.class, args);
    }
}