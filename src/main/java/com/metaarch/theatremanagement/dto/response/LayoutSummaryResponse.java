package com.metaarch.theatremanagement.dto.response;

import com.metaarch.theatremanagement.enums.LayoutStatus;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LayoutSummaryResponse {
  private Long id;
  private String layoutName;
  private Integer totalSeats;
  private LayoutStatus status;
}
