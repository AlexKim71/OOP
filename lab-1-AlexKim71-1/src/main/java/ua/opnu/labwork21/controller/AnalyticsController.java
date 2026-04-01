package ua.opnu.labwork21.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AnalyticsController {

    @GetMapping("/analytics/hotels/count")
    public ResponseEntity<String> getHotelsCount() {
        return ResponseEntity.ok("GET /analytics/hotels/count OK");
    }

    @GetMapping("/analytics/rooms/count")
    public ResponseEntity<String> getRoomsCount() {
        return ResponseEntity.ok("GET /analytics/rooms/count OK");
    }

    @GetMapping("/analytics/bookings/active")
    public ResponseEntity<String> getActiveBookingsCount() {
        return ResponseEntity.ok("GET /analytics/bookings/active OK");
    }

    @GetMapping("/analytics/bookings/completed")
    public ResponseEntity<String> getCompletedBookingsCount() {
        return ResponseEntity.ok("GET /analytics/bookings/completed OK");
    }

    @GetMapping("/analytics/rooms/by-type")
    public ResponseEntity<String> getRoomsByType() {
        return ResponseEntity.ok("GET /analytics/rooms/by-type OK");
    }
}

