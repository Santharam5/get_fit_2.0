package com.santharam.get_fit.gym.serviceImplementation;
import com.santharam.get_fit.GlobalExceptionHandler.HandleEntityAlreadyExistsException;
import com.santharam.get_fit.GlobalExceptionHandler.ResourceNotFoundException;
import com.santharam.get_fit.gym.dto.GymRequestDto;
import com.santharam.get_fit.gym.entity.Gym;
import com.santharam.get_fit.gym.repository.GymRepo;
import com.santharam.get_fit.gym.service.GymService;
import com.santharam.get_fit.gym.transform.GymTransformService;
import com.santharam.get_fit.membership.repository.MembershipRepo;
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
@Autowired
MembershipRepo membershipRepo;


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
        return gymRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Gym not found "+id));
    }

    @Override
    public Gym updateGym(Long id, GymRequestDto gymRequestDto) {
        Gym existing = gymRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Gym not found "+id));
        existing.setName(gymRequestDto.getName());
        existing.setDescription(gymRequestDto.getDescription());
        existing.setLocation(gymRequestDto.getLocation());
        existing.setRating(gymRequestDto.getRating());
        return gymRepo.save(existing);
    }

    @Override
    public void deleteGym(Long id) {
        // prevent delete if memberships exist for this gym
        var memberships = membershipRepo.findByGymId(id);
        if (memberships != null && !memberships.isEmpty()) {
            throw new HandleEntityAlreadyExistsException("Cannot delete gym with existing memberships "+id);
        }
        Gym existing = gymRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Gym not found "+id));
        gymRepo.delete(existing);
    }
}
