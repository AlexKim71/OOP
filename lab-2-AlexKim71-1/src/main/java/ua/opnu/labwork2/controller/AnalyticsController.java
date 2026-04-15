package ua.opnu.labwork2.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.opnu.labwork2.repository.BookingRepository;
import ua.opnu.labwork2.repository.HotelRepository;
import ua.opnu.labwork2.repository.RoomRepository;
import ua.opnu.labwork2.repository.GuestRepository;

import java.util.HashMap;
import java.util.Map;

/**
 * AnalyticsController - REST API controller for analytics
 * Контролер аналітики - REST API контролер для аналітики
 */
@RestController
@RequestMapping("/analytics")
@RequiredArgsConstructor
public class AnalyticsController {

    private final HotelRepository hotelRepository;
    private final RoomRepository roomRepository;
    private final BookingRepository bookingRepository;
    private final GuestRepository guestRepository;

    /**
     * Get total count of hotels
     * Отримати загальну кількість готелів
     * GET /analytics/hotels/count
     */
    @GetMapping("/hotels/count")
    public ResponseEntity<Map<String, Object>> getHotelsCount() {
        Map<String, Object> response = new HashMap<>();
        response.put("totalHotels", hotelRepository.count());
        return ResponseEntity.ok(response);
    }

    /**
     * Get total count of rooms
     * Отримати загальну кількість номерів
     * GET /analytics/rooms/count
     */
    @GetMapping("/rooms/count")
    public ResponseEntity<Map<String, Object>> getRoomsCount() {
        Map<String, Object> response = new HashMap<>();
        response.put("totalRooms", roomRepository.count());
        return ResponseEntity.ok(response);
    }

    /**
     * Get active bookings count
     * Отримати кількість активних бронювань
     * GET /analytics/bookings/active
     */
    @GetMapping("/bookings/active")
    public ResponseEntity<Map<String, Object>> getActiveBookingsCount() {
        Map<String, Object> response = new HashMap<>();
        response.put("activeBookings", bookingRepository.findActiveBookings().size());
        return ResponseEntity.ok(response);
    }

    /**
     * Get completed bookings count
     * Отримати кількість завершених бронювань
     * GET /analytics/bookings/completed
     */
    @GetMapping("/bookings/completed")
    public ResponseEntity<Map<String, Object>> getCompletedBookingsCount() {
        Map<String, Object> response = new HashMap<>();
        response.put("completedBookings", bookingRepository.findCompletedBookings().size());
        return ResponseEntity.ok(response);
    }

    /**
     * Get rooms by type count
     * Отримати кількість номерів за типом
     * GET /analytics/rooms/by-type
     */
    @GetMapping("/rooms/by-type")
    public ResponseEntity<Map<String, Long>> getRoomsByType() {
        Map<String, Long> response = new HashMap<>();
        roomRepository.findAll().forEach(room -> {
            response.put(room.getType(), response.getOrDefault(room.getType(), 0L) + 1);
        });
        return ResponseEntity.ok(response);
    }

    /**
     * Get all analytics
     * Отримати всю аналітику
     * GET /analytics/all
     */
    @GetMapping("/all")
    public ResponseEntity<Map<String, Object>> getAllAnalytics() {
        Map<String, Object> response = new HashMap<>();
        response.put("totalHotels", hotelRepository.count());
        response.put("totalRooms", roomRepository.count());
        response.put("totalGuests", guestRepository.count());
        response.put("totalBookings", bookingRepository.count());
        response.put("activeBookings", bookingRepository.findActiveBookings().size());
        response.put("completedBookings", bookingRepository.findCompletedBookings().size());
        return ResponseEntity.ok(response);
    }
}

