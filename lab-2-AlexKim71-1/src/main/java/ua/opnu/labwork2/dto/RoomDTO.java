package ua.opnu.labwork2.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * RoomDTO - Data Transfer Object for Room
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RoomDTO {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("number")
    private String number;

    @JsonProperty("type")
    private String type;

    @JsonProperty("pricePerNight")
    private Double pricePerNight;

    @JsonProperty("capacity")
    private Integer capacity;

    @JsonProperty("hotelId")
    private Long hotelId;
}

