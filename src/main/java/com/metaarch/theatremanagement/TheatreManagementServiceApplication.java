package com.metaarch.theatremanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;

@SpringBootApplication
@EnableMethodSecurity
public class TheatreManagementServiceApplication {

  public static void main(String[] args) {
    SpringApplication.run(TheatreManagementServiceApplication.class, args);
  }
}
