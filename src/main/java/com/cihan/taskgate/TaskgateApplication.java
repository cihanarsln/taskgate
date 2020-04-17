package com.cihan.taskgate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication
public class TaskgateApplication {

    public static void main(String[] args) {
        SpringApplication.run(TaskgateApplication.class, args);
    }

}
