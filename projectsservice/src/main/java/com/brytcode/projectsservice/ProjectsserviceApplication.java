package com.brytcode.projectsservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ProjectsserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjectsserviceApplication.class, args);
	}

}
