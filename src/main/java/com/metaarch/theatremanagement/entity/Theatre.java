package com.metaarch.theatremanagement.entity;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

import com.metaarch.theatremanagement.enums.FacilityType;
import com.metaarch.theatremanagement.enums.TheatreStatus;

import jakarta.persistence.CascadeType;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Entity

@Table(name = "theatres")
public class Theatre {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "name", nullable = false, length = 150)
  private String name;

  @Column(name = "description", length = 500)
  private String description;

  @Column(name = "contact_number", nullable = false, length = 20)
  private String contactNumber;

  @Column(name = "contact_email", nullable = false, length = 120)
  private String contactEmail;

  @Enumerated(EnumType.STRING)
  @Column(name = "status", nullable = false, length = 40)
  private TheatreStatus status;

  @ElementCollection(fetch = FetchType.EAGER)
  @CollectionTable(name = "theatre_facilities", joinColumns = @JoinColumn(name = "theatre_id"))
  @Enumerated(EnumType.STRING)
  @Column(name = "facility", nullable = false, length = 50)
  private Set<FacilityType> facilities = new HashSet<>();

  @OneToOne(mappedBy = "theatre", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
  private TheatreAddress address;

  @OneToMany(mappedBy = "theatre", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
  private Set<Screen> screens = new LinkedHashSet<>();

  @Column(name = "created_at", nullable = false, updatable = false)
  private LocalDateTime createdAt;

  @Column(name = "updated_at", nullable = false)
  private LocalDateTime updatedAt;

  @PrePersist
  void prePersist() {
    LocalDateTime now = LocalDateTime.now();
    this.createdAt = now;
    this.updatedAt = now;
  }

  @PreUpdate
  void preUpdate() {
    this.updatedAt = LocalDateTime.now();
  }

  public void attachAddress(TheatreAddress address) {
    this.address = address;
    if (address != null) {
      address.setTheatre(this);
    }
  }

  public void addScreen(Screen screen) {
    screens.add(screen);
    screen.setTheatre(this);
  }
}
