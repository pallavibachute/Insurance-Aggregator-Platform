package com.synechron;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootApplication
public class InsuranceProviderApplication {

	public static void main(String[] args) {
		SpringApplication.run(InsuranceProviderApplication.class, args);
	}

}
