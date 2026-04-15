package ua.opnu.labwork2.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.opnu.labwork2.dto.HotelDTO;
import ua.opnu.labwork2.service.HotelService;

import java.util.List;

/**
 * HotelController - REST API controller for Hotel operations
 * Контролер готелів - REST API контролер для операцій з готелями
 */
@RestController
@RequestMapping("/hotels")
@RequiredArgsConstructor
public class HotelController {

    private final HotelService hotelService;

    /**
     * Create a new hotel
     * Створити новий готель
     * POST /hotels
     */
    @PostMapping
    public ResponseEntity<HotelDTO> createHotel(@RequestBody HotelDTO hotelDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(hotelService.createHotel(hotelDTO));
    }

    /**
     * Get all hotels
     * Отримати всі готелі
     * GET /hotels
     */
    @GetMapping
    public ResponseEntity<List<HotelDTO>> getAllHotels() {
        return ResponseEntity.ok(hotelService.getAllHotels());
    }

    /**
     * Get hotel by ID
     * Отримати готель за ID
     * GET /hotels/{id}
     */
    @GetMapping("/{id}")
    public ResponseEntity<HotelDTO> getHotelById(@PathVariable Long id) {
        return ResponseEntity.ok(hotelService.getHotelById(id));
    }

    /**
     * Update hotel information
     * Оновити дані готелю
     * PUT /hotels/{id}
     */
    @PutMapping("/{id}")
    public ResponseEntity<HotelDTO> updateHotel(@PathVariable Long id, @RequestBody HotelDTO hotelDTO) {
        return ResponseEntity.ok(hotelService.updateHotel(id, hotelDTO));
    }

    /**
     * Delete hotel
     * Видалити готель
     * DELETE /hotels/{id}
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteHotel(@PathVariable Long id) {
        hotelService.deleteHotel(id);
        return ResponseEntity.noContent().build();
    }

    /**
     * Get rooms by hotel ID
     * Отримати номери готелю
     * GET /hotels/{id}/rooms
     */
    @GetMapping("/{id}/rooms")
    public ResponseEntity<String> getHotelRooms(@PathVariable Long id) {
        return ResponseEntity.ok("Rooms for hotel " + id);
    }
}

