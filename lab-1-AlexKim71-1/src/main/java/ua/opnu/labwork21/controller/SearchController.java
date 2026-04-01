package ua.opnu.labwork21.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SearchController {

    @GetMapping("/search/hotels")
    public ResponseEntity<String> searchHotels(@RequestParam String query) {
        return ResponseEntity.ok("GET /search/hotels?query=" + query + " OK");
    }

    @GetMapping("/search/rooms")
    public ResponseEntity<String> searchRooms(@RequestParam String query) {
        return ResponseEntity.ok("GET /search/rooms?query=" + query + " OK");
    }

    @GetMapping("/search/guests")
    public ResponseEntity<String> searchGuests(@RequestParam String query) {
        return ResponseEntity.ok("GET /search/guests?query=" + query + " OK");
    }
}

