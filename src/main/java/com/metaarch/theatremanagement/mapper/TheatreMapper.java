package com.metaarch.theatremanagement.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import com.metaarch.theatremanagement.dto.request.TheatreAddressRequest;
import com.metaarch.theatremanagement.dto.request.TheatreRequest;
import com.metaarch.theatremanagement.dto.response.TheatreAddressResponse;
import com.metaarch.theatremanagement.dto.response.TheatreResponse;
import com.metaarch.theatremanagement.entity.Theatre;
import com.metaarch.theatremanagement.entity.TheatreAddress;

@Mapper(config = MapStructConfig.class, uses = ScreenMapper.class)
public interface TheatreMapper {

  @Mapping(target = "id", ignore = true)
  @Mapping(target = "screens", ignore = true)
  @Mapping(target = "address", ignore = true)
  @Mapping(target = "createdAt", ignore = true)
  @Mapping(target = "updatedAt", ignore = true)
  Theatre toEntity(TheatreRequest request);

  @Mapping(target = "id", ignore = true)
  @Mapping(target = "screens", ignore = true)
  @Mapping(target = "address", ignore = true)
  @Mapping(target = "createdAt", ignore = true)
  @Mapping(target = "updatedAt", ignore = true)
  void updateEntity(TheatreRequest request, @MappingTarget Theatre theatre);

  TheatreAddress toAddressEntity(TheatreAddressRequest request);

  void updateAddressEntity(TheatreAddressRequest request, @MappingTarget TheatreAddress address);

  TheatreAddressResponse toAddressResponse(TheatreAddress address);

  TheatreResponse toResponse(Theatre theatre);
}
