package ua.opnu.labwork2.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.opnu.labwork2.dto.HotelDTO;
import ua.opnu.labwork2.entity.Hotel;
import ua.opnu.labwork2.repository.HotelRepository;

import java.util.List;
import java.util.stream.Collectors;

/**
 * HotelService - Service layer for Hotel operations
 * Сервіс готелів - сервіс для операцій з готелями
 */
@Service
@RequiredArgsConstructor
@Transactional
public class HotelService {

    private final HotelRepository hotelRepository;

    /**
     * Create a new hotel
     * Створити новий готель
     */
    public HotelDTO createHotel(HotelDTO hotelDTO) {
        Hotel hotel = Hotel.builder()
                .name(hotelDTO.getName())
                .city(hotelDTO.getCity())
                .address(hotelDTO.getAddress())
                .rating(hotelDTO.getRating())
                .build();

        Hotel savedHotel = hotelRepository.save(hotel);
        return convertToDTO(savedHotel);
    }

    /**
     * Get all hotels
     * Отримати всі готелі
     */
    public List<HotelDTO> getAllHotels() {
        return hotelRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    /**
     * Get hotel by ID
     * Отримати готель за ID
     */
    public HotelDTO getHotelById(Long id) {
        Hotel hotel = hotelRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Hotel not found with id: " + id));
        return convertToDTO(hotel);
    }

    /**
     * Update hotel
     * Оновити готель
     */
    public HotelDTO updateHotel(Long id, HotelDTO hotelDTO) {
        Hotel hotel = hotelRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Hotel not found with id: " + id));

        hotel.setName(hotelDTO.getName());
        hotel.setCity(hotelDTO.getCity());
        hotel.setAddress(hotelDTO.getAddress());
        hotel.setRating(hotelDTO.getRating());

        Hotel updatedHotel = hotelRepository.save(hotel);
        return convertToDTO(updatedHotel);
    }

    /**
     * Delete hotel
     * Видалити готель
     */
    public void deleteHotel(Long id) {
        if (!hotelRepository.existsById(id)) {
            throw new RuntimeException("Hotel not found with id: " + id);
        }
        hotelRepository.deleteById(id);
    }

    /**
     * Convert Hotel entity to HotelDTO
     * Конвертувати сутність Hotel в HotelDTO
     */
    private HotelDTO convertToDTO(Hotel hotel) {
        return HotelDTO.builder()
                .id(hotel.getId())
                .name(hotel.getName())
                .city(hotel.getCity())
                .address(hotel.getAddress())
                .rating(hotel.getRating())
                .build();
    }
}

