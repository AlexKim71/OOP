package ua.opnu.labwork2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ua.opnu.labwork2.entity.Booking;
import ua.opnu.labwork2.entity.BookingStatus;

import java.time.LocalDate;
import java.util.List;

/**
 * BookingRepository - Data Access Object for Booking entity
 */
@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {
    List<Booking> findByRoomId(Long roomId);

    List<Booking> findByGuestId(Long guestId);

    List<Booking> findByStatus(BookingStatus status);

    @Query("SELECT b FROM Booking b WHERE b.status = 'ACTIVE'")
    List<Booking> findActiveBookings();

    @Query("SELECT b FROM Booking b WHERE b.status = 'COMPLETED'")
    List<Booking> findCompletedBookings();
}

