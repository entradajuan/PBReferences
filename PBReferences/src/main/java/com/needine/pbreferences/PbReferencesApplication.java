package com.needine.pbreferences;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class PbReferencesApplication {

	public static void main(String[] args) {
		SpringApplication.run(PbReferencesApplication.class, args);
	}

}
