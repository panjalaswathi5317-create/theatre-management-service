package com.metaarch.theatremanagement.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TheatreAddressRequest {
  @NotBlank
  private String addressLine1;
  private String addressLine2;
  @NotBlank
  private String city;
  @NotBlank
  private String state;
  @NotBlank
  private String country;
  @NotBlank
  private String pincode;
  private Double latitude;
  private Double longitude;
}
