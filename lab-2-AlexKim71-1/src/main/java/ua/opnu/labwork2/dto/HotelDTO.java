package ua.opnu.labwork2.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * HotelDTO - Data Transfer Object for Hotel
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HotelDTO {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("city")
    private String city;

    @JsonProperty("address")
    private String address;

    @JsonProperty("rating")
    private Integer rating;
}

