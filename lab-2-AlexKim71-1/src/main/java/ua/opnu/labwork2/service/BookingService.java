package ua.opnu.labwork2.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.opnu.labwork2.dto.BookingDTO;
import ua.opnu.labwork2.entity.Booking;
import ua.opnu.labwork2.entity.BookingStatus;
import ua.opnu.labwork2.entity.Guest;
import ua.opnu.labwork2.entity.Room;
import ua.opnu.labwork2.repository.BookingRepository;
import ua.opnu.labwork2.repository.GuestRepository;
import ua.opnu.labwork2.repository.RoomRepository;

import java.util.List;
import java.util.stream.Collectors;

/**
 * BookingService - Service layer for Booking operations
 * Сервіс бронювань - сервіс для операцій з бронюваннями
 */
@Service
@RequiredArgsConstructor
@Transactional
public class BookingService {

    private final BookingRepository bookingRepository;
    private final RoomRepository roomRepository;
    private final GuestRepository guestRepository;

    /**
     * Create a new booking
     * Створити нове бронювання
     */
    public BookingDTO createBooking(BookingDTO bookingDTO) {
        Room room = roomRepository.findById(bookingDTO.getRoomId())
                .orElseThrow(() -> new RuntimeException("Room not found with id: " + bookingDTO.getRoomId()));

        Guest guest = guestRepository.findById(bookingDTO.getGuestId())
                .orElseThrow(() -> new RuntimeException("Guest not found with id: " + bookingDTO.getGuestId()));

        Booking booking = Booking.builder()
                .checkInDate(bookingDTO.getCheckInDate())
                .checkOutDate(bookingDTO.getCheckOutDate())
                .status(BookingStatus.valueOf(bookingDTO.getStatus() != null ? bookingDTO.getStatus() : "ACTIVE"))
                .room(room)
                .guest(guest)
                .build();

        Booking savedBooking = bookingRepository.save(booking);
        return convertToDTO(savedBooking);
    }

    /**
     * Get all bookings
     * Отримати всі бронювання
     */
    public List<BookingDTO> getAllBookings() {
        return bookingRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    /**
     * Get booking by ID
     * Отримати бронювання за ID
     */
    public BookingDTO getBookingById(Long id) {
        Booking booking = bookingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Booking not found with id: " + id));
        return convertToDTO(booking);
    }

    /**
     * Get bookings by guest ID
     * Отримати бронювання гостя за ID
     */
    public List<BookingDTO> getBookingsByGuestId(Long guestId) {
        return bookingRepository.findByGuestId(guestId).stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    /**
     * Get active bookings
     * Отримати активні бронювання
     */
    public List<BookingDTO> getActiveBookings() {
        return bookingRepository.findActiveBookings().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    /**
     * Get completed bookings
     * Отримати завершені бронювання
     */
    public List<BookingDTO> getCompletedBookings() {
        return bookingRepository.findCompletedBookings().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    /**
     * Update booking
     * Оновити бронювання
     */
    public BookingDTO updateBooking(Long id, BookingDTO bookingDTO) {
        Booking booking = bookingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Booking not found with id: " + id));

        booking.setCheckInDate(bookingDTO.getCheckInDate());
        booking.setCheckOutDate(bookingDTO.getCheckOutDate());
        booking.setStatus(BookingStatus.valueOf(bookingDTO.getStatus() != null ? bookingDTO.getStatus() : "ACTIVE"));

        Booking updatedBooking = bookingRepository.save(booking);
        return convertToDTO(updatedBooking);
    }

    /**
     * Cancel booking
     * Скасувати бронювання
     */
    public BookingDTO cancelBooking(Long id) {
        Booking booking = bookingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Booking not found with id: " + id));

        booking.setStatus(BookingStatus.CANCELLED);
        Booking updatedBooking = bookingRepository.save(booking);
        return convertToDTO(updatedBooking);
    }

    /**
     * Delete booking
     * Видалити бронювання
     */
    public void deleteBooking(Long id) {
        if (!bookingRepository.existsById(id)) {
            throw new RuntimeException("Booking not found with id: " + id);
        }
        bookingRepository.deleteById(id);
    }

    /**
     * Convert Booking entity to BookingDTO
     * Конвертувати сутність Booking в BookingDTO
     */
    private BookingDTO convertToDTO(Booking booking) {
        return BookingDTO.builder()
                .id(booking.getId())
                .checkInDate(booking.getCheckInDate())
                .checkOutDate(booking.getCheckOutDate())
                .status(booking.getStatus().toString())
                .roomId(booking.getRoom().getId())
                .guestId(booking.getGuest().getId())
                .build();
    }
}

