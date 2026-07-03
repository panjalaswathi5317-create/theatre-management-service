package com.metaarch.theatremanagement.dto.request;

import com.metaarch.theatremanagement.enums.ScreenStatus;
import com.metaarch.theatremanagement.enums.ScreenType;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ScreenRequest {
  @NotBlank
  private String screenName;
  @NotNull
  private ScreenType screenType;
  @NotNull
  @Positive
  private Integer totalSeats;
  @NotNull
  private ScreenStatus status;
}
