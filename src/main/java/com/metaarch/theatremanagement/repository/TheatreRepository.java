package com.metaarch.theatremanagement.repository;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.metaarch.theatremanagement.entity.Theatre;

public interface TheatreRepository extends JpaRepository<Theatre, Long>, JpaSpecificationExecutor<Theatre> {

  @EntityGraph(attributePaths = { "address", "screens" })
  java.util.Optional<Theatre> findWithDetailsById(Long id);
}
