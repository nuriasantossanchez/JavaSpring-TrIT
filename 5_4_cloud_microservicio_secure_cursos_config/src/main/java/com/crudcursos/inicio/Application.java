package com.crudcursos.inicio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages = { "com.crudcursos.dao" })
@EntityScan(basePackages = { "com.crudcursos.model" })
@SpringBootApplication(scanBasePackages = { "com.crudcursos.controller", "com.crudcursos.service","com.crudcursos.inicio" })
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
