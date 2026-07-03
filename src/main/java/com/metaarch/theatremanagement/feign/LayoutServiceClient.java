package com.metaarch.theatremanagement.feign;

import com.metaarch.theatremanagement.dto.response.LayoutSummaryResponse;

public interface LayoutServiceClient {
  LayoutSummaryResponse getLayoutById(Long layoutId);
}
