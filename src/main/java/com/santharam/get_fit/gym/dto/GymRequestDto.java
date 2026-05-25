package com.santharam.get_fit.gym.dto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GymRequestDto {
    // Gym name
    private String name;
    //Gym location
    private String location;
    //Gym rating
    private Integer rating;
    //Gym description
    private String description;

}
