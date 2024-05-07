package com.example.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProjectApplication {

	public static void main(String[] args) {
		System.setProperty("spring.main.allow-circular-references", "true");
		SpringApplication.run(ProjectApplication.class, args);
	}

}
