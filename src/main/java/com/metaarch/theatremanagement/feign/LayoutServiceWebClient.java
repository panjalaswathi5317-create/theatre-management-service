package com.metaarch.theatremanagement.feign;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import com.metaarch.theatremanagement.dto.response.LayoutSummaryResponse;
import com.metaarch.theatremanagement.exception.BusinessException;
import com.metaarch.theatremanagement.exception.ResourceNotFoundException;

@Component
public class LayoutServiceWebClient implements LayoutServiceClient {
	
  private final WebClient layoutWebClient;

  public LayoutServiceWebClient(WebClient layoutWebClient) {
    this.layoutWebClient = layoutWebClient;
  }

  @Override
  public LayoutSummaryResponse getLayoutById(Long layoutId) {
   
	  return layoutWebClient
      .get()
      .uri("/api/layouts/{layoutId}", layoutId)
      .retrieve()
      .onStatus(
        status -> status.value() == 404,
        response -> response.bodyToMono(String.class)
          .map(body -> new ResourceNotFoundException("Layout not found with id: " + layoutId))
      )
      .onStatus(
        status -> status.is4xxClientError() || status.is5xxServerError(),
        response -> response.bodyToMono(String.class)
          .map(body -> new BusinessException("Unable to validate layout with layout-service"))
      )
      .bodyToMono(LayoutSummaryResponse.class)
      .block();
	  
	  
	  
	  
	  
	  
  }
}
