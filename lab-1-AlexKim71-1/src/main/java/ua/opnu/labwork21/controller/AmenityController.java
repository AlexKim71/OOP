package ua.opnu.labwork21.controller;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ua.opnu.labwork21.entity.Amenity;
import ua.opnu.labwork21.entity.Room;

@RestController
public class AmenityController {

    @PostMapping("/amenities")
    public ResponseEntity<Amenity> createAmenity(@RequestBody Amenity amenity) {
        Amenity stub = new Amenity(1L, "Wi-Fi", "Free high-speed internet");
        return ResponseEntity.ok(stub);
    }

    @GetMapping("/amenities")
    public ResponseEntity<List<Amenity>> getAmenities() {
        List<Amenity> stubs = List.of(
            new Amenity(1L, "Wi-Fi", "Free high-speed internet"),
            new Amenity(2L, "Parking", "Private parking area")
        );
        return ResponseEntity.ok(stubs);
    }

    @GetMapping("/amenities/{id}")
    public ResponseEntity<Amenity> getAmenityById(@PathVariable Long id) {
        Amenity stub = new Amenity(id, "Wi-Fi", "Free high-speed internet");
        return ResponseEntity.ok(stub);
    }

    @DeleteMapping("/amenities/{id}")
    public ResponseEntity<Amenity> deleteAmenity(@PathVariable Long id) {
        Amenity stub = new Amenity(id, "Deleted amenity", "Removed from system");
        return ResponseEntity.ok(stub);
    }

    @PostMapping("/rooms/{id}/amenities/{amenityId}")
    public ResponseEntity<Room> addAmenityToRoom(@PathVariable Long id, @PathVariable Long amenityId) {
        Room stub = new Room(id, "501", "DELUXE", 180.0, 2);
        return ResponseEntity.ok(stub);
    }

    @DeleteMapping("/rooms/{id}/amenities/{amenityId}")
    public ResponseEntity<Room> removeAmenityFromRoom(@PathVariable Long id, @PathVariable Long amenityId) {
        Room stub = new Room(id, "501", "DELUXE", 180.0, 2);
        return ResponseEntity.ok(stub);
    }
}


