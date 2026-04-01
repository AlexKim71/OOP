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
import ua.opnu.labwork21.entity.Hotel;

@RestController
@RequestMapping("/hotels")
public class HotelController {

    @PostMapping
    public ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel) {
        Hotel stub = new Hotel(1L, "Grand Palace", "Odesa", "Shevchenka Ave, 1", 5);
        return ResponseEntity.ok(stub);
    }

    @GetMapping
    public ResponseEntity<List<Hotel>> getHotels() {
        List<Hotel> stubs = List.of(
            new Hotel(1L, "Grand Palace", "Odesa", "Shevchenka Ave, 1", 5),
            new Hotel(2L, "Sea View", "Lviv", "Freedom Sq, 10", 4)
        );
        return ResponseEntity.ok(stubs);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Hotel> getHotelById(@PathVariable Long id) {
        Hotel stub = new Hotel(id, "Grand Palace", "Odesa", "Shevchenka Ave, 1", 5);
        return ResponseEntity.ok(stub);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Hotel> updateHotel(@PathVariable Long id, @RequestBody Hotel hotel) {
        Hotel stub = new Hotel(id, "Updated Hotel", "Kyiv", "Khreshchatyk, 5", 4);
        return ResponseEntity.ok(stub);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Hotel> deleteHotel(@PathVariable Long id) {
        Hotel stub = new Hotel(id, "Deleted Hotel", "Dnipro", "Central St, 99", 3);
        return ResponseEntity.ok(stub);
    }

    @GetMapping("/{id}/rooms")
    public ResponseEntity<Hotel> getHotelRooms(@PathVariable Long id) {
        Hotel stub = new Hotel(id, "Hotel With Rooms", "Odesa", "Deribasivska, 7", 5);
        return ResponseEntity.ok(stub);
    }
}

