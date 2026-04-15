package ua.opnu.labwork2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.opnu.labwork2.entity.Amenity;

import java.util.List;

/**
 * AmenityRepository - Data Access Object for Amenity entity
 */
@Repository
public interface AmenityRepository extends JpaRepository<Amenity, Long> {
    List<Amenity> findByHotelId(Long hotelId);
}

