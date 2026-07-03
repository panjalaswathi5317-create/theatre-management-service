package com.metaarch.theatremanagement.dto.response;

import com.metaarch.theatremanagement.enums.ScreenStatus;
import com.metaarch.theatremanagement.enums.ScreenType;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ScreenResponse {
  private Long id;
  private String screenName;
  private ScreenType screenType;
  private Integer totalSeats;
  private ScreenStatus status;
  private Long layoutId;
  private Long theatreId;
}
