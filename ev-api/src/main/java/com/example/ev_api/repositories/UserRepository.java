package com.example.ev_api.repositories;

import com.example.ev_api.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

// By extending JpaRepository, we get all standard database methods for free!
public interface UserRepository extends JpaRepository<User, Integer> {
    // Spring Data JPA will automatically create a query for this method name
    Optional<User> findByEmail(String email);
}