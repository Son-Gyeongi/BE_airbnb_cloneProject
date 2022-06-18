package com.sparta.airbnb_clone_be.repository;

import com.sparta.airbnb_clone_be.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
