package com.metaarch.theatremanagement.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.metaarch.theatremanagement.entity.Screen;

public interface ScreenRepository extends JpaRepository<Screen, Long> {
  Optional<Screen> findByIdAndTheatreId(Long id, Long theatreId);
}
