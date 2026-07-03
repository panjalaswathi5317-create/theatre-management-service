package com.metaarch.theatremanagement.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import com.metaarch.theatremanagement.dto.request.ScreenRequest;
import com.metaarch.theatremanagement.dto.response.ScreenResponse;
import com.metaarch.theatremanagement.entity.Screen;

@Mapper(config = MapStructConfig.class)
public interface ScreenMapper {

  Screen toEntity(ScreenRequest request);

  void updateEntity(ScreenRequest request, @MappingTarget Screen screen);

  @Mapping(target = "theatreId", source = "theatre.id")
  ScreenResponse toResponse(Screen screen);
}
