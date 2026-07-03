package com.metaarch.theatremanagement.util;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.metaarch.theatremanagement.dto.request.TheatreSearchRequest;
import com.metaarch.theatremanagement.entity.Theatre;
import com.metaarch.theatremanagement.entity.TheatreAddress;

import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.JoinType;

@Component
public class TheatreSpecifications {

  public Specification<Theatre> search(TheatreSearchRequest request) {
    return (root, query, builder) -> {
      query.distinct(true);
      var predicate = builder.conjunction();

      if (StringUtils.hasText(request.getTheatreName())) {
        predicate = builder.and(
          predicate,
          builder.like(builder.lower(root.get("name")), "%" + request.getTheatreName().toLowerCase() + "%")
        );
      }

      if (request.getStatus() != null) {
        predicate = builder.and(predicate, builder.equal(root.get("status"), request.getStatus()));
      }

      if (StringUtils.hasText(request.getCity())) {
        Join<Theatre, TheatreAddress> addressJoin = root.join("address", JoinType.INNER);
        predicate = builder.and(
          predicate,
          builder.like(builder.lower(addressJoin.get("city")), "%" + request.getCity().toLowerCase() + "%")
        );
      }

      if (request.getFacility() != null) {
        Join<Object, Object> facilitiesJoin = root.join("facilities", JoinType.INNER);
        predicate = builder.and(predicate, builder.equal(facilitiesJoin, request.getFacility()));
      }

      return predicate;
    };
  }
}
