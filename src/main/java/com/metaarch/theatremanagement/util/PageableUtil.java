package com.metaarch.theatremanagement.util;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
public class PageableUtil {

  public Pageable build(int page, int size, String sortBy, String direction) {
    String resolvedSortBy = StringUtils.hasText(sortBy) ? sortBy : "id";
    Sort.Direction sortDirection =
      "desc".equalsIgnoreCase(direction) ? Sort.Direction.DESC : Sort.Direction.ASC;
    return PageRequest.of(page, size, Sort.by(sortDirection, resolvedSortBy));
  }
}
