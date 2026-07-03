package com.metaarch.theatremanagement.service.impl;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.metaarch.theatremanagement.dto.request.TheatreRequest;
import com.metaarch.theatremanagement.dto.request.TheatreSearchRequest;
import com.metaarch.theatremanagement.dto.response.TheatreResponse;
import com.metaarch.theatremanagement.entity.Theatre;
import com.metaarch.theatremanagement.entity.TheatreAddress;
import com.metaarch.theatremanagement.exception.ResourceNotFoundException;
import com.metaarch.theatremanagement.mapper.TheatreMapper;
import com.metaarch.theatremanagement.repository.TheatreRepository;
import com.metaarch.theatremanagement.service.TheatreService;
import com.metaarch.theatremanagement.util.PageableUtil;
import com.metaarch.theatremanagement.util.TheatreSpecifications;

@Service
public class TheatreServiceImpl implements TheatreService {
  private final TheatreRepository theatreRepository;
  private final TheatreMapper theatreMapper;
  private final TheatreSpecifications theatreSpecifications;
  private final PageableUtil pageableUtil;

  public TheatreServiceImpl(
    TheatreRepository theatreRepository,
    TheatreMapper theatreMapper,
    TheatreSpecifications theatreSpecifications,
    PageableUtil pageableUtil
  ) {
    this.theatreRepository = theatreRepository;
    this.theatreMapper = theatreMapper;
    this.theatreSpecifications = theatreSpecifications;
    this.pageableUtil = pageableUtil;
  }

  @Override
  @Transactional
  public TheatreResponse createTheatre(TheatreRequest request) {
    Theatre theatre = theatreMapper.toEntity(request);
    TheatreAddress address = theatreMapper.toAddressEntity(request.getAddress());
    theatre.attachAddress(address);
    return theatreMapper.toResponse(theatreRepository.save(theatre));
  }

  @Override
  @Transactional
  public TheatreResponse updateTheatre(Long theatreId, TheatreRequest request) {
    Theatre theatre = findTheatre(theatreId);
    theatreMapper.updateEntity(request, theatre);
    if (theatre.getAddress() == null) {
      theatre.attachAddress(theatreMapper.toAddressEntity(request.getAddress()));
    } else {
      theatreMapper.updateAddressEntity(request.getAddress(), theatre.getAddress());
    }
    return theatreMapper.toResponse(theatreRepository.save(theatre));
  }

  @Override
  @Transactional(readOnly = true)
  public TheatreResponse getTheatreById(Long theatreId) {
    return theatreMapper.toResponse(findTheatre(theatreId));
  }

  @Override
  @Transactional
  public void deleteTheatre(Long theatreId) {
    theatreRepository.delete(findTheatre(theatreId));
  }

  @Override
  @Transactional(readOnly = true)
  public Page<TheatreResponse> searchTheatres(
    TheatreSearchRequest request,
    int page,
    int size,
    String sortBy,
    String direction
  ) {
    return theatreRepository.findAll(
      theatreSpecifications.search(request),
      pageableUtil.build(page, size, sortBy, direction)
    ).map(theatreMapper::toResponse);
  }

  private Theatre findTheatre(Long theatreId) {
    return theatreRepository.findWithDetailsById(theatreId)
      .orElseThrow(() -> new ResourceNotFoundException("Theatre not found with id: " + theatreId));
  }
}
