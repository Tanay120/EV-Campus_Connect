package com.example.ev_api.repositories; // Using your package name from the error log

import com.example.ev_api.models.Booking;
import com.example.ev_api.models.User;
import com.example.ev_api.models.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Integer> {

    List<Booking> findByUser(User user);

    // NEW METHOD: Add this line.
    // Spring Data JPA will automatically create the database query based on the method name.
    boolean existsByUserAndVehicle(User user, Vehicle vehicle);
}