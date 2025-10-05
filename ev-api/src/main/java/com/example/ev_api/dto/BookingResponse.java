package com.example.ev_api.dto;

import lombok.Builder;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Builder
public class BookingResponse {
    private Integer id;
    private String vehicleName;
    private String vehicleImageUrl;
    private LocalDateTime bookingTime;
}