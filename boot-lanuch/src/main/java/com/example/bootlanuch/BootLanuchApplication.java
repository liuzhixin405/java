package com.example.bootlanuch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource(locations = {"classpath:beans.xml"})
public class BootLanuchApplication {

    public static void main(String[] args) {
        SpringApplication.run(BootLanuchApplication.class, args);
    }

}
