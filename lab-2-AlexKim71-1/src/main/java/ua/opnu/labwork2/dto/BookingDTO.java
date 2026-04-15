package ua.opnu.labwork2.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

/**
 * BookingDTO - Data Transfer Object for Booking
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookingDTO {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("checkInDate")
    private LocalDate checkInDate;

    @JsonProperty("checkOutDate")
    private LocalDate checkOutDate;

    @JsonProperty("status")
    private String status;

    @JsonProperty("roomId")
    private Long roomId;

    @JsonProperty("guestId")
    private Long guestId;
}

