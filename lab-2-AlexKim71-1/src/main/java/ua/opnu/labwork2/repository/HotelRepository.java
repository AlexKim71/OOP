package ua.opnu.labwork2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.opnu.labwork2.entity.Hotel;

/**
 * HotelRepository - Data Access Object for Hotel entity
 */
@Repository
public interface HotelRepository extends JpaRepository<Hotel, Long> {
}

