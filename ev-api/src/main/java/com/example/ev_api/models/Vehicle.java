package com.example.ev_api.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String type; // e.g., "scooter", "bike"
    private String imageUrl;
    private String price;
    @Column(name="vehicle_range") // "range" can be a reserved word
    private String range;
    private String topSpeed;
    private String offer;
}