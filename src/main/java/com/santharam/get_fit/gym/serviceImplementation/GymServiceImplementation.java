package com.santharam.get_fit.gym.serviceImplementation;
import com.santharam.get_fit.gym.dto.GymRequestDto;
import com.santharam.get_fit.gym.entity.Gym;
import com.santharam.get_fit.gym.repository.GymRepo;
import com.santharam.get_fit.gym.service.GymService;
import com.santharam.get_fit.gym.transform.GymTransformService;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Builder
@Data
@Service
@AllArgsConstructor
@NoArgsConstructor
public class GymServiceImplementation implements GymService {
@Autowired
    GymRepo gymRepo;
@Autowired
    GymTransformService gymTransformService;


    @Override
    public Gym createGym(GymRequestDto gymRequestDto) {
        Gym gym=gymTransformService.toEntity(gymRequestDto);
        return gymRepo.save(gym);
    }

    @Override
    public List<Gym> getAllGyms() {
        return gymRepo.findAll();
    }

    @Override
    public Gym getGym(Long id) {
        return gymRepo.findById(id).orElseThrow(()->new RuntimeException("Gym not found"));
    }
}
