package com.art.platform.config;
import org.springframework.stereotype.Component;

@Component
public class Service {

    private final String message;

    public Service(String message) {
        this.message = message;
    }

    public String message() {
        return this.message;
    }
}
