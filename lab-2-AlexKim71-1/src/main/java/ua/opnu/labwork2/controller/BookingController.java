package ua.opnu.labwork2.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.opnu.labwork2.dto.BookingDTO;
import ua.opnu.labwork2.service.BookingService;

import java.util.List;

/**
 * BookingController - REST API controller for Booking operations
 * Контролер бронювань - REST API контролер для операцій з бронюваннями
 */
@RestController
@RequestMapping("/bookings")
@RequiredArgsConstructor
public class BookingController {

    private final BookingService bookingService;

    /**
     * Create a new booking
     * Створити нове бронювання
     * POST /bookings
     */
    @PostMapping
    public ResponseEntity<BookingDTO> createBooking(@RequestBody BookingDTO bookingDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(bookingService.createBooking(bookingDTO));
    }

    /**
     * Get all bookings
     * Отримати всі бронювання
     * GET /bookings
     */
    @GetMapping
    public ResponseEntity<List<BookingDTO>> getAllBookings() {
        return ResponseEntity.ok(bookingService.getAllBookings());
    }

    /**
     * Get booking by ID
     * Отримати бронювання за ID
     * GET /bookings/{id}
     */
    @GetMapping("/{id}")
    public ResponseEntity<BookingDTO> getBookingById(@PathVariable Long id) {
        return ResponseEntity.ok(bookingService.getBookingById(id));
    }

    /**
     * Update booking information
     * Оновити дані бронювання
     * PUT /bookings/{id}
     */
    @PutMapping("/{id}")
    public ResponseEntity<BookingDTO> updateBooking(@PathVariable Long id, @RequestBody BookingDTO bookingDTO) {
        return ResponseEntity.ok(bookingService.updateBooking(id, bookingDTO));
    }

    /**
     * Cancel booking
     * Скасувати бронювання
     * DELETE /bookings/{id}
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<BookingDTO> cancelBooking(@PathVariable Long id) {
        return ResponseEntity.ok(bookingService.cancelBooking(id));
    }

    /**
     * Get active bookings
     * Отримати активні бронювання
     * GET /bookings/active
     */
    @GetMapping("/active")
    public ResponseEntity<List<BookingDTO>> getActiveBookings() {
        return ResponseEntity.ok(bookingService.getActiveBookings());
    }
}

