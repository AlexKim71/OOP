package ua.opnu.labwork2.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.opnu.labwork2.dto.GuestDTO;
import ua.opnu.labwork2.entity.Guest;
import ua.opnu.labwork2.repository.GuestRepository;

import java.util.List;
import java.util.stream.Collectors;

/**
 * GuestService - Service layer for Guest operations
 * Сервіс гостей - сервіс для операцій з гостями
 */
@Service
@RequiredArgsConstructor
@Transactional
public class GuestService {

    private final GuestRepository guestRepository;

    /**
     * Register a new guest
     * Зареєструвати нового гостя
     */
    public GuestDTO registerGuest(GuestDTO guestDTO) {
        Guest guest = Guest.builder()
                .firstName(guestDTO.getFirstName())
                .lastName(guestDTO.getLastName())
                .email(guestDTO.getEmail())
                .phone(guestDTO.getPhone())
                .build();

        Guest savedGuest = guestRepository.save(guest);
        return convertToDTO(savedGuest);
    }

    /**
     * Get all guests
     * Отримати всіх гостей
     */
    public List<GuestDTO> getAllGuests() {
        return guestRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    /**
     * Get guest by ID
     * Отримати гостя за ID
     */
    public GuestDTO getGuestById(Long id) {
        Guest guest = guestRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Guest not found with id: " + id));
        return convertToDTO(guest);
    }

    /**
     * Update guest information
     * Оновити інформацію про гостя
     */
    public GuestDTO updateGuest(Long id, GuestDTO guestDTO) {
        Guest guest = guestRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Guest not found with id: " + id));

        guest.setFirstName(guestDTO.getFirstName());
        guest.setLastName(guestDTO.getLastName());
        guest.setEmail(guestDTO.getEmail());
        guest.setPhone(guestDTO.getPhone());

        Guest updatedGuest = guestRepository.save(guest);
        return convertToDTO(updatedGuest);
    }

    /**
     * Delete guest
     * Видалити гостя
     */
    public void deleteGuest(Long id) {
        if (!guestRepository.existsById(id)) {
            throw new RuntimeException("Guest not found with id: " + id);
        }
        guestRepository.deleteById(id);
    }

    /**
     * Convert Guest entity to GuestDTO
     * Конвертувати сутність Guest в GuestDTO
     */
    private GuestDTO convertToDTO(Guest guest) {
        return GuestDTO.builder()
                .id(guest.getId())
                .firstName(guest.getFirstName())
                .lastName(guest.getLastName())
                .email(guest.getEmail())
                .phone(guest.getPhone())
                .build();
    }
}

