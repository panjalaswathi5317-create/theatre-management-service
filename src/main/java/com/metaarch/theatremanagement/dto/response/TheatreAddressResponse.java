package com.metaarch.theatremanagement.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TheatreAddressResponse {
  private Long id;
  private String addressLine1;
  private String addressLine2;
  private String city;
  private String state;
  private String country;
  private String pincode;
  private Double latitude;
  private Double longitude;
}
