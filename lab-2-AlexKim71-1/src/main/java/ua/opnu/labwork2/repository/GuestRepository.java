package ua.opnu.labwork2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.opnu.labwork2.entity.Guest;

/**
 * GuestRepository - Data Access Object for Guest entity
 */
@Repository
public interface GuestRepository extends JpaRepository<Guest, Long> {
}

