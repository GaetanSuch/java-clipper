package com.bootstrap.clipper;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class ClipperApplication {
    static void main(String[] args) {
        SpringApplication.run(ClipperApplication.class, args);
    }
}