package ua.opnu.labwork2.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.opnu.labwork2.dto.GuestDTO;
import ua.opnu.labwork2.service.GuestService;

import java.util.List;

/**
 * GuestController - REST API controller for Guest operations
 * Контролер гостей - REST API контролер для операцій з гостями
 */
@RestController
@RequestMapping("/guests")
@RequiredArgsConstructor
public class GuestController {

    private final GuestService guestService;

    /**
     * Register a new guest
     * Зареєструвати нового гостя
     * POST /guests
     */
    @PostMapping
    public ResponseEntity<GuestDTO> registerGuest(@RequestBody GuestDTO guestDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(guestService.registerGuest(guestDTO));
    }

    /**
     * Get all guests
     * Отримати всіх гостей
     * GET /guests
     */
    @GetMapping
    public ResponseEntity<List<GuestDTO>> getAllGuests() {
        return ResponseEntity.ok(guestService.getAllGuests());
    }

    /**
     * Get guest by ID
     * Отримати гостя за ID
     * GET /guests/{id}
     */
    @GetMapping("/{id}")
    public ResponseEntity<GuestDTO> getGuestById(@PathVariable Long id) {
        return ResponseEntity.ok(guestService.getGuestById(id));
    }

    /**
     * Update guest information
     * Оновити дані гостя
     * PUT /guests/{id}
     */
    @PutMapping("/{id}")
    public ResponseEntity<GuestDTO> updateGuest(@PathVariable Long id, @RequestBody GuestDTO guestDTO) {
        return ResponseEntity.ok(guestService.updateGuest(id, guestDTO));
    }

    /**
     * Delete guest
     * Видалити гостя
     * DELETE /guests/{id}
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGuest(@PathVariable Long id) {
        guestService.deleteGuest(id);
        return ResponseEntity.noContent().build();
    }

    /**
     * Get guest bookings
     * Отримати бронювання гостя
     * GET /guests/{id}/bookings
     */
    @GetMapping("/{id}/bookings")
    public ResponseEntity<String> getGuestBookings(@PathVariable Long id) {
        return ResponseEntity.ok("Bookings for guest " + id);
    }
}

