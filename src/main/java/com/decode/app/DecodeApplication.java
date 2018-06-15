package com.decode.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.decode")
public class DecodeApplication {

	public static void main(String[] args) {
		SpringApplication.run(DecodeApplication.class, args);
	}
}
