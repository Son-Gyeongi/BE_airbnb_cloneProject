package com.sparta.airbnb_clone_be.repository;

import com.sparta.airbnb_clone_be.model.Accomodations;
import com.sparta.airbnb_clone_be.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AccomodationsRepository extends JpaRepository<User, Long> {
     Optional<Accomodations> findById(long accomodationsId);

}
