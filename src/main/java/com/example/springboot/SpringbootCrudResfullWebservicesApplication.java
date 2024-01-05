package com.example.springboot;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.ui.ModelMap;

import javax.management.modelmbean.ModelMBean;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(
		title = "Spring Boot Rest API Documentation",
		description = "Spring Boot Rest API Documentation",
		version = "v1.0",
		contact = @Contact(
				name = "Hassouni Larbi",
				email = "Larbi.Hassouni@univh2c.ma",
				url = "https://sites.google.com/view/hassouni/"
		),
		license = @License(
				name = "Apache 2.0",
				url = "https://sites.google.com/view/hassouni/license"
		)
),
externalDocs = @ExternalDocumentation(
		description = "Spring Boot User management Documentation",
		url = "https://sites.google.com/view/hassouni/user_management.html"
))
public class SpringbootCrudResfullWebservicesApplication {
	@Bean
	public ModelMapper modelMapper(){
		return new ModelMapper();
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringbootCrudResfullWebservicesApplication.class, args);
	}

}
