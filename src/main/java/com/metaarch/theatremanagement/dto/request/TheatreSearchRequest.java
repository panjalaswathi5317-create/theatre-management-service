package com.metaarch.theatremanagement.dto.request;

import com.metaarch.theatremanagement.enums.FacilityType;
import com.metaarch.theatremanagement.enums.TheatreStatus;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TheatreSearchRequest {
  private String city;
  private String theatreName;
  private TheatreStatus status;
  private FacilityType facility;
}
