package ua.opnu.labwork2.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.opnu.labwork2.dto.AmenityDTO;
import ua.opnu.labwork2.service.AmenityService;

import java.util.List;

/**
 * AmenityController - REST API controller for Amenity operations
 * Контролер зручностей - REST API контролер для операцій з зручностями
 */
@RestController
@RequestMapping("/amenities")
@RequiredArgsConstructor
public class AmenityController {

    private final AmenityService amenityService;

    /**
     * Create a new amenity
     * Створити нову зручність
     * POST /amenities
     */
    @PostMapping
    public ResponseEntity<AmenityDTO> createAmenity(@RequestBody AmenityDTO amenityDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(amenityService.createAmenity(amenityDTO));
    }

    /**
     * Get all amenities
     * Отримати всі зручності
     * GET /amenities
     */
    @GetMapping
    public ResponseEntity<List<AmenityDTO>> getAllAmenities() {
        return ResponseEntity.ok(amenityService.getAllAmenities());
    }

    /**
     * Get amenity by ID
     * Отримати зручність за ID
     * GET /amenities/{id}
     */
    @GetMapping("/{id}")
    public ResponseEntity<AmenityDTO> getAmenityById(@PathVariable Long id) {
        return ResponseEntity.ok(amenityService.getAmenityById(id));
    }

    /**
     * Delete amenity
     * Видалити зручність
     * DELETE /amenities/{id}
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAmenity(@PathVariable Long id) {
        amenityService.deleteAmenity(id);
        return ResponseEntity.noContent().build();
    }

    /**
     * Add amenity to room
     * Додати зручність до номера
     * POST /rooms/{roomId}/amenities/{amenityId}
     */
    @PostMapping("/rooms/{roomId}/amenities/{amenityId}")
    public ResponseEntity<Void> addAmenityToRoom(@PathVariable Long roomId, @PathVariable Long amenityId) {
        amenityService.addAmenityToRoom(roomId, amenityId);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    /**
     * Remove amenity from room
     * Видалити зручність з номера
     * DELETE /rooms/{roomId}/amenities/{amenityId}
     */
    @DeleteMapping("/rooms/{roomId}/amenities/{amenityId}")
    public ResponseEntity<Void> removeAmenityFromRoom(@PathVariable Long roomId, @PathVariable Long amenityId) {
        amenityService.removeAmenityFromRoom(roomId, amenityId);
        return ResponseEntity.noContent().build();
    }
}

