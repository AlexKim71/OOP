package ua.opnu.labwork2.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.opnu.labwork2.dto.AmenityDTO;
import ua.opnu.labwork2.entity.Amenity;
import ua.opnu.labwork2.entity.Hotel;
import ua.opnu.labwork2.entity.Room;
import ua.opnu.labwork2.repository.AmenityRepository;
import ua.opnu.labwork2.repository.HotelRepository;
import ua.opnu.labwork2.repository.RoomRepository;

import java.util.List;
import java.util.stream.Collectors;

/**
 * AmenityService - Service layer for Amenity operations
 * Сервіс зручностей - сервіс для операцій з зручностями номерів
 */
@Service
@RequiredArgsConstructor
@Transactional
public class AmenityService {

    private final AmenityRepository amenityRepository;
    private final HotelRepository hotelRepository;
    private final RoomRepository roomRepository;

    /**
     * Create a new amenity
     * Створити нову зручність
     */
    public AmenityDTO createAmenity(AmenityDTO amenityDTO) {
        Hotel hotel = hotelRepository.findById(amenityDTO.getHotelId())
                .orElseThrow(() -> new RuntimeException("Hotel not found with id: " + amenityDTO.getHotelId()));

        Amenity amenity = Amenity.builder()
                .name(amenityDTO.getName())
                .description(amenityDTO.getDescription())
                .hotel(hotel)
                .build();

        Amenity savedAmenity = amenityRepository.save(amenity);
        return convertToDTO(savedAmenity);
    }

    /**
     * Get all amenities
     * Отримати всі зручності
     */
    public List<AmenityDTO> getAllAmenities() {
        return amenityRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    /**
     * Get amenity by ID
     * Отримати зручність за ID
     */
    public AmenityDTO getAmenityById(Long id) {
        Amenity amenity = amenityRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Amenity not found with id: " + id));
        return convertToDTO(amenity);
    }

    /**
     * Delete amenity
     * Видалити зручність
     */
    public void deleteAmenity(Long id) {
        if (!amenityRepository.existsById(id)) {
            throw new RuntimeException("Amenity not found with id: " + id);
        }
        amenityRepository.deleteById(id);
    }

    /**
     * Add amenity to room
     * Додати зручність до номера
     */
    public void addAmenityToRoom(Long roomId, Long amenityId) {
        Room room = roomRepository.findById(roomId)
                .orElseThrow(() -> new RuntimeException("Room not found with id: " + roomId));

        Amenity amenity = amenityRepository.findById(amenityId)
                .orElseThrow(() -> new RuntimeException("Amenity not found with id: " + amenityId));

        room.getAmenities().add(amenity);
        roomRepository.save(room);
    }

    /**
     * Remove amenity from room
     * Видалити зручність з номера
     */
    public void removeAmenityFromRoom(Long roomId, Long amenityId) {
        Room room = roomRepository.findById(roomId)
                .orElseThrow(() -> new RuntimeException("Room not found with id: " + roomId));

        Amenity amenity = amenityRepository.findById(amenityId)
                .orElseThrow(() -> new RuntimeException("Amenity not found with id: " + amenityId));

        room.getAmenities().remove(amenity);
        roomRepository.save(room);
    }

    /**
     * Convert Amenity entity to AmenityDTO
     * Конвертувати сутність Amenity в AmenityDTO
     */
    private AmenityDTO convertToDTO(Amenity amenity) {
        return AmenityDTO.builder()
                .id(amenity.getId())
                .name(amenity.getName())
                .description(amenity.getDescription())
                .hotelId(amenity.getHotel().getId())
                .build();
    }
}

