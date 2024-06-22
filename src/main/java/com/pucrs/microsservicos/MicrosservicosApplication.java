package com.pucrs.microsservicos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = {"com.pucrs"})
public class MicrosservicosApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicrosservicosApplication.class, args);
	}

}
