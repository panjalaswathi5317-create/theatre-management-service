package com.metaarch.theatremanagement.service;

import org.springframework.data.domain.Page;

import com.metaarch.theatremanagement.dto.request.TheatreRequest;
import com.metaarch.theatremanagement.dto.request.TheatreSearchRequest;
import com.metaarch.theatremanagement.dto.response.TheatreResponse;

public interface TheatreService {
  TheatreResponse createTheatre(TheatreRequest request);
  TheatreResponse updateTheatre(Long theatreId, TheatreRequest request);
  TheatreResponse getTheatreById(Long theatreId);
  void deleteTheatre(Long theatreId);
  Page<TheatreResponse> searchTheatres(TheatreSearchRequest request, int page, int size, String sortBy, String direction);
}
