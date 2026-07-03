package com.metaarch.theatremanagement.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {

  @Bean
  @LoadBalanced
  public WebClient.Builder loadBalancedWebClientBuilder() {
    return WebClient.builder();
  }

  @Bean
  public WebClient layoutWebClient(
    WebClient.Builder webClientBuilder,
    @Value("${app.clients.layout-service.base-url}") String layoutServiceBaseUrl
  ) {
    return webClientBuilder.baseUrl(layoutServiceBaseUrl).build();
  }
}
