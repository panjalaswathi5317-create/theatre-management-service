package com.metaarch.theatremanagement.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.metaarch.theatremanagement.dto.request.ScreenRequest;
import com.metaarch.theatremanagement.dto.response.LayoutSummaryResponse;
import com.metaarch.theatremanagement.dto.response.ScreenResponse;
import com.metaarch.theatremanagement.entity.Screen;
import com.metaarch.theatremanagement.entity.Theatre;
import com.metaarch.theatremanagement.enums.LayoutStatus;
import com.metaarch.theatremanagement.exception.BusinessException;
import com.metaarch.theatremanagement.exception.ResourceNotFoundException;
import com.metaarch.theatremanagement.feign.LayoutServiceClient;
import com.metaarch.theatremanagement.mapper.ScreenMapper;
import com.metaarch.theatremanagement.repository.ScreenRepository;
import com.metaarch.theatremanagement.repository.TheatreRepository;
import com.metaarch.theatremanagement.service.ScreenService;

@Service
public class ScreenServiceImpl implements ScreenService {
  private final ScreenRepository screenRepository;
  private final TheatreRepository theatreRepository;
  private final ScreenMapper screenMapper;
  private final LayoutServiceClient layoutServiceClient;

  public ScreenServiceImpl(
    ScreenRepository screenRepository,
    TheatreRepository theatreRepository,
    ScreenMapper screenMapper,
    LayoutServiceClient layoutServiceClient
  ) {
    this.screenRepository = screenRepository;
    this.theatreRepository = theatreRepository;
    this.screenMapper = screenMapper;
    this.layoutServiceClient = layoutServiceClient;
  }

  @Override
  @Transactional
  public ScreenResponse createScreen(Long theatreId, ScreenRequest request) {
    Theatre theatre = theatreRepository.findById(theatreId)
      .orElseThrow(() -> new ResourceNotFoundException("Theatre not found with id: " + theatreId));
    Screen screen = screenMapper.toEntity(request);
    screen.setTheatre(theatre);
    return screenMapper.toResponse(screenRepository.save(screen));
  }

  @Override
  @Transactional
  public ScreenResponse updateScreen(Long screenId, ScreenRequest request) {
    Screen screen = findScreen(screenId);
    screenMapper.updateEntity(request, screen);
    return screenMapper.toResponse(screenRepository.save(screen));
  }

  @Override
  @Transactional(readOnly = true)
  public ScreenResponse getScreenById(Long screenId) {
    return screenMapper.toResponse(findScreen(screenId));
  }

  @Override
  @Transactional
  public ScreenResponse attachLayout(Long screenId, Long layoutId) {
    Screen screen = findScreen(screenId);
    LayoutSummaryResponse layout = layoutServiceClient.getLayoutById(layoutId);

    if (layout == null) {
      throw new ResourceNotFoundException("Layout not found with id: " + layoutId);
    }
    if (layout.getStatus() != LayoutStatus.ACTIVE) {
      throw new BusinessException("Only ACTIVE layouts can be attached to a screen");
    }
    if (!screen.getTotalSeats().equals(layout.getTotalSeats())) {
      throw new BusinessException("Screen totalSeats must match layout totalSeats");
    }

    screen.setLayoutId(layoutId);
    return screenMapper.toResponse(screenRepository.save(screen));
  }

  private Screen findScreen(Long screenId) {
    return screenRepository.findById(screenId)
      .orElseThrow(() -> new ResourceNotFoundException("Screen not found with id: " + screenId));
  }
}
