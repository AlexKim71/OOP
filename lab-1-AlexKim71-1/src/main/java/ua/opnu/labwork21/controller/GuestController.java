package ua.opnu.labwork21.controller;

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
import ua.opnu.labwork21.entity.Guest;

@RestController
@RequestMapping("/guests")
public class GuestController {

    @PostMapping
    public ResponseEntity<Guest> createGuest(@RequestBody Guest guest) {
        Guest stub = new Guest(1L, "Ivan", "Petrenko", "ivan@example.com", "+380500000001");
        return ResponseEntity.ok(stub);
    }

    @GetMapping
    public ResponseEntity<List<Guest>> getGuests() {
        List<Guest> stubs = List.of(
            new Guest(1L, "Ivan", "Petrenko", "ivan@example.com", "+380500000001"),
            new Guest(2L, "Olena", "Koval", "olena@example.com", "+380500000002")
        );
        return ResponseEntity.ok(stubs);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Guest> getGuestById(@PathVariable Long id) {
        Guest stub = new Guest(id, "Ivan", "Petrenko", "ivan@example.com", "+380500000001");
        return ResponseEntity.ok(stub);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Guest> updateGuest(@PathVariable Long id, @RequestBody Guest guest) {
        Guest stub = new Guest(id, "Updated", "Guest", "updated@example.com", "+380500000003");
        return ResponseEntity.ok(stub);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Guest> deleteGuest(@PathVariable Long id) {
        Guest stub = new Guest(id, "Deleted", "Guest", "deleted@example.com", "+380500000004");
        return ResponseEntity.ok(stub);
    }

    @GetMapping("/{id}/bookings")
    public ResponseEntity<Guest> getGuestBookings(@PathVariable Long id) {
        Guest stub = new Guest(id, "Booked", "Guest", "booked@example.com", "+380500000005");
        return ResponseEntity.ok(stub);
    }
}

