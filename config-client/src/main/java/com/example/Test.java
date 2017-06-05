package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Import;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.art.platform.config.Service;
import com.art.platform.config.ServiceConfiguration;




@SpringBootApplication
@Import(ServiceConfiguration.class)
@RestController
@RefreshScope
@EnableAutoConfiguration
public class Test {
	
	@Value("${service.message1}")
	private String message1;

    private final Service service;

    @Autowired
    public Test(Service service) {
        this.service = service;
    }

    @GetMapping("/")
    public String home() {
    	System.out.println("..............................................."+service.message());
    	System.out.println(".......................message1........................"+message1);
        return service.message();
    }

    public static void main(String[] args) {
        SpringApplication.run(Test.class, args);
    }
}