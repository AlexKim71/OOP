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
import ua.opnu.labwork21.entity.Room;

@RestController
@RequestMapping("/rooms")
public class RoomController {

    @PostMapping
    public ResponseEntity<Room> createRoom(@RequestBody Room room) {
        Room stub = new Room(1L, "101", "STANDARD", 120.0, 2);
        return ResponseEntity.ok(stub);
    }

    @GetMapping
    public ResponseEntity<List<Room>> getRooms() {
        List<Room> stubs = List.of(
            new Room(1L, "101", "STANDARD", 120.0, 2),
            new Room(2L, "202", "DELUXE", 210.0, 3)
        );
        return ResponseEntity.ok(stubs);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Room> getRoomById(@PathVariable Long id) {
        Room stub = new Room(id, "101", "STANDARD", 120.0, 2);
        return ResponseEntity.ok(stub);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Room> updateRoom(@PathVariable Long id, @RequestBody Room room) {
        Room stub = new Room(id, "305", "SUITE", 300.0, 4);
        return ResponseEntity.ok(stub);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Room> deleteRoom(@PathVariable Long id) {
        Room stub = new Room(id, "000", "DELETED", 0.0, 0);
        return ResponseEntity.ok(stub);
    }

    @GetMapping("/hotel/{hotelId}")
    public ResponseEntity<Room> getRoomsByHotel(@PathVariable Long hotelId) {
        Room stub = new Room(10L, "401", "STANDARD", 130.0, 2);
        return ResponseEntity.ok(stub);
    }
}

