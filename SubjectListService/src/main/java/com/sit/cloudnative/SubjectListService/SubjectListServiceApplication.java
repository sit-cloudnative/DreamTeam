package com.sit.cloudnative.SubjectListService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SubjectListServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SubjectListServiceApplication.class, args);
	}
}
