package com.sparta.airbnb_clone_be.repository;

import com.sparta.airbnb_clone_be.model.Accommodation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AccommodationRepository extends JpaRepository<Accommodation, Long> {
     Optional<Accommodation> findById(long accommodationsId);
     List<Accommodation> findByCategory(String category);

}
