package com.metaarch.theatremanagement.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class OpenApiConfig {

  @Bean
  public OpenAPI theatreManagementOpenApi() {
    return new OpenAPI()
      .info(new Info()
        .title("Theatre Management Service API")
        .version("v1")
        .description("Production-style theatre and screen management APIs")
        .contact(new Contact().name("Booking Platform Team").email("platform@example.com")));
  }
}
