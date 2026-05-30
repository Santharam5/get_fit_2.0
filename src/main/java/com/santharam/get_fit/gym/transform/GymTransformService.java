package com.santharam.get_fit.gym.transform;

import com.santharam.get_fit.gym.dto.GymRequestDto;
import com.santharam.get_fit.gym.entity.Gym;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@Builder
@Data
public class GymTransformService {
    public Gym toEntity(GymRequestDto gymRequestDto){
      return Gym.builder()
              .name(gymRequestDto.getName())
              .description(gymRequestDto.getDescription())
              .location(gymRequestDto.getLocation())
              .rating(gymRequestDto.getRating())
              .build();
    }
}
