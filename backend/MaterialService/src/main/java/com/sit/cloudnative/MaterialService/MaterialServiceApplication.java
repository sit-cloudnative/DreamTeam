package com.sit.cloudnative.MaterialService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class MaterialServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(MaterialServiceApplication.class, args);

    }
}
