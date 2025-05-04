package com.learning.annotations;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
@ComponentScan("com.learning.annotations.Annotations.JPA_PART1")
public class AnnotationsApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(AnnotationsApplication.class, args);
//		context.close();
	}

}
