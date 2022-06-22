package com.sparta.airbnb_clone_be.repository;

import com.sparta.airbnb_clone_be.model.Accommodation;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.Optional;
import java.util.List;

public interface AccommodationRepository extends JpaRepository<Accommodation, Long> {
    Optional<Accommodation> findById(Long id);

    List<Accommodation> findByCategory(String category);


}
