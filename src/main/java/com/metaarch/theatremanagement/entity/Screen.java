package com.metaarch.theatremanagement.entity;

import com.metaarch.theatremanagement.enums.ScreenStatus;
import com.metaarch.theatremanagement.enums.ScreenType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "screens")
public class Screen {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "screen_name", nullable = false, length = 120)
  private String screenName;

  @Enumerated(EnumType.STRING)
  @Column(name = "screen_type", nullable = false, length = 40)
  private ScreenType screenType;

  @Column(name = "total_seats", nullable = false)
  private Integer totalSeats;

  @Enumerated(EnumType.STRING)
  @Column(name = "status", nullable = false, length = 40)
  private ScreenStatus status;

  @Column(name = "layout_id")
  private Long layoutId;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "theatre_id", nullable = false)
  private Theatre theatre;
}
