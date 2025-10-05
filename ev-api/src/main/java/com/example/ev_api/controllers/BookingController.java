package com.example.ev_api.controllers;

import com.example.ev_api.dto.BookingResponse;
import com.example.ev_api.services.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/bookings")
@RequiredArgsConstructor
public class BookingController {

    private final BookingService bookingService;

    @PostMapping
    public ResponseEntity<BookingResponse> createBooking(@RequestBody Map<String, Integer> payload) {
        Integer vehicleId = payload.get("vehicleId");
        return ResponseEntity.ok(bookingService.createBooking(vehicleId));
    }

    @GetMapping("/my-bookings")
    public ResponseEntity<List<BookingResponse>> getMyBookings() {
        return ResponseEntity.ok(bookingService.getMyBookings());
    }

    // Inside public class BookingController { ...

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBooking(@PathVariable Integer id) {
        bookingService.deleteBooking(id);
        return ResponseEntity.noContent().build(); // Returns a 204 No Content status on success
    }
}