package com.metaarch.theatremanagement.controller;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.metaarch.theatremanagement.dto.request.TheatreRequest;
import com.metaarch.theatremanagement.dto.request.TheatreSearchRequest;
import com.metaarch.theatremanagement.dto.response.ApiResponse;
import com.metaarch.theatremanagement.dto.response.PageResponse;
import com.metaarch.theatremanagement.dto.response.TheatreResponse;
import com.metaarch.theatremanagement.enums.FacilityType;
import com.metaarch.theatremanagement.enums.TheatreStatus;
import com.metaarch.theatremanagement.service.TheatreService;
import com.metaarch.theatremanagement.util.ApiResponseBuilder;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;

@RestController
@Validated
@RequestMapping("/api/theatres")
public class TheatreController {
  private final TheatreService theatreService;
  private final ApiResponseBuilder apiResponseBuilder;

  public TheatreController(TheatreService theatreService, ApiResponseBuilder apiResponseBuilder) {
    this.theatreService = theatreService;
    this.apiResponseBuilder = apiResponseBuilder;
  }

  @PostMapping
  public ResponseEntity<ApiResponse<TheatreResponse>> createTheatre(@Valid @RequestBody TheatreRequest request) {
    return ResponseEntity.status(HttpStatus.CREATED)
      .body(apiResponseBuilder.success("Theatre created successfully", theatreService.createTheatre(request)));
  }

  @PutMapping("/{id}")
  public ResponseEntity<ApiResponse<TheatreResponse>> updateTheatre(
    @PathVariable Long id,
    @Valid @RequestBody TheatreRequest request
  ) {
    return ResponseEntity.ok(
      apiResponseBuilder.success("Theatre updated successfully", theatreService.updateTheatre(id, request))
    );
  }

  @GetMapping("/{id}")
  public ResponseEntity<ApiResponse<TheatreResponse>> getTheatre(@PathVariable Long id) {
    return ResponseEntity.ok(
      apiResponseBuilder.success("Theatre fetched successfully", theatreService.getTheatreById(id))
    );
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<ApiResponse<Void>> deleteTheatre(@PathVariable Long id) {
    theatreService.deleteTheatre(id);
    return ResponseEntity.ok(apiResponseBuilder.success("Theatre deleted successfully", null));
  }

  @GetMapping("/search")
  public ResponseEntity<ApiResponse<PageResponse<TheatreResponse>>> searchTheatres(
    @RequestParam(required = false) String city,
    @RequestParam(required = false) String theatreName,
    @RequestParam(required = false) TheatreStatus status,
    @RequestParam(required = false) FacilityType facility,
    @RequestParam(defaultValue = "0") @Min(0) int page,
    @RequestParam(defaultValue = "10") @Min(1) int size,
    @RequestParam(defaultValue = "id") String sortBy,
    @RequestParam(defaultValue = "asc") String direction
  ) {
    TheatreSearchRequest request = new TheatreSearchRequest();
    request.setCity(city);
    request.setTheatreName(theatreName);
    request.setStatus(status);
    request.setFacility(facility);

    return ResponseEntity.ok(apiResponseBuilder.success(
      "Theatres fetched successfully",
      apiResponseBuilder.page(theatreService.searchTheatres(request, page, size, sortBy, direction))
    ));
  }

  @GetMapping("/health")
  public ResponseEntity<Map<String, String>> health() {
    return ResponseEntity.ok(Map.of("service", "theatre-management-service", "status", "UP"));
  }
}
