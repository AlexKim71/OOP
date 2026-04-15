package ua.opnu.labwork2.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.opnu.labwork2.dto.HotelDTO;
import ua.opnu.labwork2.dto.RoomDTO;
import ua.opnu.labwork2.dto.GuestDTO;
import ua.opnu.labwork2.repository.HotelRepository;
import ua.opnu.labwork2.repository.RoomRepository;
import ua.opnu.labwork2.repository.GuestRepository;

import java.util.List;
import java.util.stream.Collectors;

/**
 * SearchController - REST API controller for search operations
 * Контролер пошуку - REST API контролер для операцій пошуку
 */
@RestController
@RequestMapping("/search")
@RequiredArgsConstructor
public class SearchController {

    private final HotelRepository hotelRepository;
    private final RoomRepository roomRepository;
    private final GuestRepository guestRepository;

    /**
     * Search hotels by name or city
     * Пошук готелів за назвою або містом
     * GET /search/hotels?query=...
     */
    @GetMapping("/hotels")
    public ResponseEntity<List<HotelDTO>> searchHotels(@RequestParam String query) {
        List<HotelDTO> results = hotelRepository.findAll().stream()
                .filter(h -> h.getName().toLowerCase().contains(query.toLowerCase()) || 
                           h.getCity().toLowerCase().contains(query.toLowerCase()))
                .map(h -> HotelDTO.builder()
                        .id(h.getId())
                        .name(h.getName())
                        .city(h.getCity())
                        .address(h.getAddress())
                        .rating(h.getRating())
                        .build())
                .collect(Collectors.toList());
        return ResponseEntity.ok(results);
    }

    /**
     * Search rooms by type
     * Пошук номерів за типом
     * GET /search/rooms?query=...
     */
    @GetMapping("/rooms")
    public ResponseEntity<List<RoomDTO>> searchRooms(@RequestParam String query) {
        List<RoomDTO> results = roomRepository.findAll().stream()
                .filter(r -> r.getType().toLowerCase().contains(query.toLowerCase()))
                .map(r -> RoomDTO.builder()
                        .id(r.getId())
                        .number(r.getNumber())
                        .type(r.getType())
                        .pricePerNight(r.getPricePerNight())
                        .capacity(r.getCapacity())
                        .hotelId(r.getHotel().getId())
                        .build())
                .collect(Collectors.toList());
        return ResponseEntity.ok(results);
    }

    /**
     * Search guests by name
     * Пошук гостей за ім'ям
     * GET /search/guests?query=...
     */
    @GetMapping("/guests")
    public ResponseEntity<List<GuestDTO>> searchGuests(@RequestParam String query) {
        List<GuestDTO> results = guestRepository.findAll().stream()
                .filter(g -> g.getFirstName().toLowerCase().contains(query.toLowerCase()) || 
                           g.getLastName().toLowerCase().contains(query.toLowerCase()))
                .map(g -> GuestDTO.builder()
                        .id(g.getId())
                        .firstName(g.getFirstName())
                        .lastName(g.getLastName())
                        .email(g.getEmail())
                        .phone(g.getPhone())
                        .build())
                .collect(Collectors.toList());
        return ResponseEntity.ok(results);
    }
}

