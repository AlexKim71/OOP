package ua.opnu.labwork2.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * AmenityDTO - Data Transfer Object for Amenity
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AmenityDTO {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("description")
    private String description;

    @JsonProperty("hotelId")
    private Long hotelId;
}

