package com.metaarch.theatremanagement.dto.request;

import java.util.Set;

import com.metaarch.theatremanagement.enums.FacilityType;
import com.metaarch.theatremanagement.enums.TheatreStatus;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TheatreRequest {
  @NotBlank
  private String name;
  private String description;
  @NotBlank
  private String contactNumber;
  @NotBlank
  @Email
  private String contactEmail;
  @NotNull
  private TheatreStatus status;
  @NotEmpty
  private Set<FacilityType> facilities;
  @NotNull
  @Valid
  private TheatreAddressRequest address;
}
