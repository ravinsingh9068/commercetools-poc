package com.test.commercetoolpoc.catalog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages="com.test.commercetoolpoc.*")
@EntityScan("com.test.commercetoolpoc.*")
public class CatalogImportApplication {

	public static void main(String[] args) {
		SpringApplication.run(CatalogImportApplication.class, args);
	}
}
