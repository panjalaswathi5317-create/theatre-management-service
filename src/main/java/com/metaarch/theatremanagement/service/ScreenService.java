package com.metaarch.theatremanagement.service;

import com.metaarch.theatremanagement.dto.request.ScreenRequest;
import com.metaarch.theatremanagement.dto.response.ScreenResponse;

public interface ScreenService {
  ScreenResponse createScreen(Long theatreId, ScreenRequest request);
  ScreenResponse updateScreen(Long screenId, ScreenRequest request);
  ScreenResponse getScreenById(Long screenId);
  ScreenResponse attachLayout(Long screenId, Long layoutId);
}
