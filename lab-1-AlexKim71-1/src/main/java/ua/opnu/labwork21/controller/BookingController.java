package ua.opnu.labwork21.controller;

import java.time.LocalDate;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.opnu.labwork21.entity.Booking;
import ua.opnu.labwork21.entity.BookingStatus;

@RestController
@RequestMapping("/bookings")
public class BookingController {

    @PostMapping
    public ResponseEntity<Booking> createBooking(@RequestBody Booking booking) {
        Booking stub = new Booking(1L, LocalDate.now(), LocalDate.now().plusDays(2), BookingStatus.NEW);
        return ResponseEntity.ok(stub);
    }

    @GetMapping
    public ResponseEntity<List<Booking>> getBookings() {
        List<Booking> stubs = List.of(
            new Booking(1L, LocalDate.now(), LocalDate.now().plusDays(2), BookingStatus.ACTIVE),
            new Booking(2L, LocalDate.now().minusDays(5), LocalDate.now().minusDays(1), BookingStatus.COMPLETED)
        );
        return ResponseEntity.ok(stubs);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Booking> getBookingById(@PathVariable Long id) {
        Booking stub = new Booking(id, LocalDate.now(), LocalDate.now().plusDays(1), BookingStatus.ACTIVE);
        return ResponseEntity.ok(stub);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Booking> updateBooking(@PathVariable Long id, @RequestBody Booking booking) {
        Booking stub = new Booking(id, LocalDate.now().plusDays(1), LocalDate.now().plusDays(3), BookingStatus.ACTIVE);
        return ResponseEntity.ok(stub);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Booking> deleteBooking(@PathVariable Long id) {
        Booking stub = new Booking(id, LocalDate.now(), LocalDate.now().plusDays(1), BookingStatus.CANCELED);
        return ResponseEntity.ok(stub);
    }

    @GetMapping("/active")
    public ResponseEntity<Booking> getActiveBookings() {
        Booking stub = new Booking(10L, LocalDate.now(), LocalDate.now().plusDays(4), BookingStatus.ACTIVE);
        return ResponseEntity.ok(stub);
    }
}

