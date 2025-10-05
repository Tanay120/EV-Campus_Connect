package com.example.ev_api.repositories;
import com.example.ev_api.models.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
public interface VehicleRepository extends JpaRepository<Vehicle, Integer> {}