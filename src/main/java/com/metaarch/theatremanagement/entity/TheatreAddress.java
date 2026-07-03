package com.metaarch.theatremanagement.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "theatre_addresses")
public class TheatreAddress {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "address_line_1", nullable = false, length = 150)
  private String addressLine1;

  @Column(name = "address_line_2", length = 150)
  private String addressLine2;

  @Column(name = "city", nullable = false, length = 80)
  private String city;

  @Column(name = "state", nullable = false, length = 80)
  private String state;

  @Column(name = "country", nullable = false, length = 80)
  private String country;

  @Column(name = "pincode", nullable = false, length = 20)
  private String pincode;

  @Column(name = "latitude", precision = 10)
  private Double latitude;

  @Column(name = "longitude", precision = 10)
  private Double longitude;

  @OneToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "theatre_id", nullable = false, unique = true)
  private Theatre theatre;
}
