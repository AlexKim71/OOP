package ua.opnu.labwork2.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.opnu.labwork2.dto.RoomDTO;
import ua.opnu.labwork2.entity.Hotel;
import ua.opnu.labwork2.entity.Room;
import ua.opnu.labwork2.repository.HotelRepository;
import ua.opnu.labwork2.repository.RoomRepository;

import java.util.List;
import java.util.stream.Collectors;

/**
 * RoomService - Service layer for Room operations
 * Сервіс номерів - сервіс для операцій з номерами
 */
@Service
@RequiredArgsConstructor
@Transactional
public class RoomService {

    private final RoomRepository roomRepository;
    private final HotelRepository hotelRepository;

    /**
     * Create a new room
     * Створити новий номер
     */
    public RoomDTO createRoom(RoomDTO roomDTO) {
        Hotel hotel = hotelRepository.findById(roomDTO.getHotelId())
                .orElseThrow(() -> new RuntimeException("Hotel not found with id: " + roomDTO.getHotelId()));

        Room room = Room.builder()
                .number(roomDTO.getNumber())
                .type(roomDTO.getType())
                .pricePerNight(roomDTO.getPricePerNight())
                .capacity(roomDTO.getCapacity())
                .hotel(hotel)
                .build();

        Room savedRoom = roomRepository.save(room);
        return convertToDTO(savedRoom);
    }

    /**
     * Get all rooms
     * Отримати всі номери
     */
    public List<RoomDTO> getAllRooms() {
        return roomRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    /**
     * Get room by ID
     * Отримати номер за ID
     */
    public RoomDTO getRoomById(Long id) {
        Room room = roomRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Room not found with id: " + id));
        return convertToDTO(room);
    }

    /**
     * Get rooms by hotel ID
     * Отримати номери за ID готелю
     */
    public List<RoomDTO> getRoomsByHotelId(Long hotelId) {
        return roomRepository.findByHotelId(hotelId).stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    /**
     * Update room
     * Оновити номер
     */
    public RoomDTO updateRoom(Long id, RoomDTO roomDTO) {
        Room room = roomRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Room not found with id: " + id));

        room.setNumber(roomDTO.getNumber());
        room.setType(roomDTO.getType());
        room.setPricePerNight(roomDTO.getPricePerNight());
        room.setCapacity(roomDTO.getCapacity());

        Room updatedRoom = roomRepository.save(room);
        return convertToDTO(updatedRoom);
    }

    /**
     * Delete room
     * Видалити номер
     */
    public void deleteRoom(Long id) {
        if (!roomRepository.existsById(id)) {
            throw new RuntimeException("Room not found with id: " + id);
        }
        roomRepository.deleteById(id);
    }

    /**
     * Convert Room entity to RoomDTO
     * Конвертувати сутність Room в RoomDTO
     */
    private RoomDTO convertToDTO(Room room) {
        return RoomDTO.builder()
                .id(room.getId())
                .number(room.getNumber())
                .type(room.getType())
                .pricePerNight(room.getPricePerNight())
                .capacity(room.getCapacity())
                .hotelId(room.getHotel().getId())
                .build();
    }
}

