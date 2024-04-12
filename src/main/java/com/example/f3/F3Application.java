package com.example.f3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class F3Application {

    public static void main(String[] args) {
        SpringApplication.run(F3Application.class, args);
    }

}
