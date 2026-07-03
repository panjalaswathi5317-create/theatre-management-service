package com.metaarch.theatremanagement.util;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import com.metaarch.theatremanagement.dto.response.ApiResponse;
import com.metaarch.theatremanagement.dto.response.PageResponse;

@Component
public class ApiResponseBuilder {

  public <T> ApiResponse<T> success(String message, T data) {
    return ApiResponse.<T>builder()
      .success(true)
      .message(message)
      .data(data)
      .build();
  }

  public <T> PageResponse<T> page(Page<T> page) {
    return PageResponse.<T>builder()
      .content(page.getContent())
      .page(page.getNumber())
      .size(page.getSize())
      .totalElements(page.getTotalElements())
      .totalPages(page.getTotalPages())
      .first(page.isFirst())
      .last(page.isLast())
      .build();
  }
}
