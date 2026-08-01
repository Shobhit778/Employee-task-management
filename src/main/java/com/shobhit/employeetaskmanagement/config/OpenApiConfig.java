package com.shobhit.employeetaskmanagement.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI employeeTaskManagementAPI() {

        return new OpenAPI()
                .info(new Info()
                        .title("Employee Task Management System API")
                        .description("REST APIs for managing employees and tasks using Spring Boot.")
                        .version("1.0.0")
                        .contact(new Contact()
                                .name("Shobhit Gupta")
                                .email("shobhitgupta828@gmail.com")))
                .externalDocs(new ExternalDocumentation()
                        .description("Project Documentation"));
    }
}