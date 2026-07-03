package com.metaarch.theatremanagement.dto.response;

import java.time.LocalDateTime;
import java.util.Set;

import com.metaarch.theatremanagement.enums.FacilityType;
import com.metaarch.theatremanagement.enums.TheatreStatus;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TheatreResponse {
  private Long id;
  private String name;
  private String description;
  private String contactNumber;
  private String contactEmail;
  private TheatreStatus status;
  private Set<FacilityType> facilities;
  private TheatreAddressResponse address;
  private Set<ScreenResponse> screens;
  private LocalDateTime createdAt;
  private LocalDateTime updatedAt;
}
