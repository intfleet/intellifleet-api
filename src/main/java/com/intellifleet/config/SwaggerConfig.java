package com.intellifleet.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("My Spring Boot API")
                        .version("1.0")
                        .description("Spring Boot REST API Documentation")
                        .contact(new Contact()
                                .name("Your Name")
                                .email("your@email.com")))
                .externalDocs(new ExternalDocumentation()
                        .description("Project Documentation"));
    }
}
