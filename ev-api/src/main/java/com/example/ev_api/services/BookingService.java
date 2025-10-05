package com.example.ev_api.services;

import com.example.ev_api.dto.BookingResponse;
import com.example.ev_api.models.Booking;
import com.example.ev_api.models.User;
import com.example.ev_api.models.Vehicle;
import com.example.ev_api.repositories.BookingRepository;
import com.example.ev_api.repositories.UserRepository; // <-- NEW IMPORT
import com.example.ev_api.repositories.VehicleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException; // <-- NEW IMPORT
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookingService {

    private final BookingRepository bookingRepository;
    private final VehicleRepository vehicleRepository;
    private final UserRepository userRepository; // <-- NEW DEPENDENCY

    // A helper method to get the current user in a safe way
    private User getCurrentUser() {
        String userEmail = SecurityContextHolder.getContext().getAuthentication().getName();
        return userRepository.findByEmail(userEmail)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with email: " + userEmail));
    }

    public BookingResponse createBooking(Integer vehicleId) {
        User currentUser = getCurrentUser(); // <-- SAFER METHOD

        Vehicle vehicle = vehicleRepository.findById(vehicleId)
                .orElseThrow(() -> new RuntimeException("Vehicle not found"));

        if (bookingRepository.existsByUserAndVehicle(currentUser, vehicle)) {
            throw new IllegalStateException("You have already booked this vehicle.");
        }

        Booking booking = Booking.builder()
                .user(currentUser)
                .vehicle(vehicle)
                .bookingTime(LocalDateTime.now())
                .build();

        Booking savedBooking = bookingRepository.save(booking);
        return mapToBookingResponse(savedBooking);
    }

    public List<BookingResponse> getMyBookings() {
        User currentUser = getCurrentUser(); // <-- SAFER METHOD
        return bookingRepository.findByUser(currentUser)
                .stream()
                .map(this::mapToBookingResponse)
                .collect(Collectors.toList());
    }

    public void deleteBooking(Integer bookingId) {
        User currentUser = getCurrentUser(); // <-- SAFER METHOD

        Booking booking = bookingRepository.findById(bookingId)
                .orElseThrow(() -> new RuntimeException("Booking not found"));

        if (!booking.getUser().getId().equals(currentUser.getId())) {
            throw new IllegalStateException("You do not have permission to delete this booking.");
        }

        bookingRepository.delete(booking);
    }

    private BookingResponse mapToBookingResponse(Booking booking) {
        return BookingResponse.builder()
                .id(booking.getId())
                .vehicleName(booking.getVehicle().getName())
                .vehicleImageUrl(booking.getVehicle().getImageUrl())
                .bookingTime(booking.getBookingTime())
                .build();
    }
}