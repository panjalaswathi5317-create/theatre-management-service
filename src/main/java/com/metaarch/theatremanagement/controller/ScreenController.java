package com.metaarch.theatremanagement.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.metaarch.theatremanagement.dto.request.ScreenRequest;
import com.metaarch.theatremanagement.dto.response.ApiResponse;
import com.metaarch.theatremanagement.dto.response.ScreenResponse;
import com.metaarch.theatremanagement.service.ScreenService;
import com.metaarch.theatremanagement.util.ApiResponseBuilder;

import jakarta.validation.Valid;

@RestController
@Validated
@RequestMapping("/api")
public class ScreenController {
  private final ScreenService screenService;
  private final ApiResponseBuilder apiResponseBuilder;

  public ScreenController(ScreenService screenService, ApiResponseBuilder apiResponseBuilder) {
    this.screenService = screenService;
    this.apiResponseBuilder = apiResponseBuilder;
  }

  @PostMapping("/theatres/{theatreId}/screens")
  public ResponseEntity<ApiResponse<ScreenResponse>> createScreen(
    @PathVariable Long theatreId,
    @Valid @RequestBody ScreenRequest request
  ) {
    return ResponseEntity.status(HttpStatus.CREATED)
      .body(apiResponseBuilder.success("Screen created successfully", screenService.createScreen(theatreId, request)));
  }

  @PutMapping("/screens/{screenId}")
  public ResponseEntity<ApiResponse<ScreenResponse>> updateScreen(
    @PathVariable Long screenId,
    @Valid @RequestBody ScreenRequest request
  ) {
    return ResponseEntity.ok(
      apiResponseBuilder.success("Screen updated successfully", screenService.updateScreen(screenId, request))
    );
  }

  @GetMapping("/screens/{screenId}")
  public ResponseEntity<ApiResponse<ScreenResponse>> getScreen(@PathVariable Long screenId) {
    return ResponseEntity.ok(
      apiResponseBuilder.success("Screen fetched successfully", screenService.getScreenById(screenId))
    );
  }

  @PatchMapping("/screens/{screenId}/layout/{layoutId}")
  public ResponseEntity<ApiResponse<ScreenResponse>> attachLayout(
    @PathVariable Long screenId,
    @PathVariable Long layoutId
  ) {
    return ResponseEntity.ok(
      apiResponseBuilder.success("Layout attached successfully", screenService.attachLayout(screenId, layoutId))
    );
  }
}
