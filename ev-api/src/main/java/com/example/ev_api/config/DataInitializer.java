package com.example.ev_api.config;

import com.example.ev_api.models.Vehicle;
import com.example.ev_api.repositories.VehicleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {

    private final VehicleRepository vehicleRepository;

    @Override
    public void run(String... args) throws Exception {
        // Only add data if the vehicle table is empty
        if (vehicleRepository.count() == 0) {
            Vehicle scooter1 = Vehicle.builder().name("Ola S1 Pro").type("scooter").price("₹ 1,49,000").range("180 km").topSpeed("115 km/h").offer("Campus discount: ₹5,000 off").imageUrl("https://upload.wikimedia.org/wikipedia/commons/7/7a/OLA_S1_Pro_Gen_1_Electric_Scooter.jpg").build();
            Vehicle scooter2 = Vehicle.builder().name("Ather 450X").type("scooter").price("₹ 1,47,000").range("146 km").topSpeed("90 km/h").offer("2 years warranty extension").imageUrl("https://upload.wikimedia.org/wikipedia/commons/thumb/4/4e/Frank-e%2C_Frankfurt_am_Main_%28LRM_20210417_155159%29.jpg/640px-Frank-e%2C_Frankfurt_am_Main_%28LRM_20210417_155159%29.jpg").build();
            Vehicle bike1 = Vehicle.builder().name("Revolt RV400").type("bike").price("₹ 1,42,900").range("150 km").topSpeed("85 km/h").offer("Book campus test ride").imageUrl("https://upload.wikimedia.org/wikipedia/commons/thumb/5/52/ZEV_Electric_T-5100_Electric_Motorcycle.jpg/640px-ZEV_Electric_T-5100_Electric_Motorcycle.jpg").build();

            vehicleRepository.saveAll(List.of(scooter1, scooter2, bike1));
            System.out.println("✅ Database seeded with initial vehicle data.");
        }
    }
}