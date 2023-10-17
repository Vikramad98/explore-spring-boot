package com.vikram;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.vikram.JavaSpringBoot")
public class ExploreSpringBootApplication {

	public static void main(String[] args) {

		SpringApplication.run(ExploreSpringBootApplication.class, args);

	}

}
