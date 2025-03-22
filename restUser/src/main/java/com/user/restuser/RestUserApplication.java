package com.user.restuser;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RestUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(RestUserApplication.class, args);
        System.out.println("start Rest User App");
    }

}
