package com.santharam.get_fit.routine.serviceImplementation;

import com.santharam.get_fit.routine.dto.RoutineRequestDto;
import com.santharam.get_fit.routine.entity.Routine;
import com.santharam.get_fit.routine.repository.RoutineRepo;
import com.santharam.get_fit.routine.service.RoutineService;
import com.santharam.get_fit.routine.transform.RoutineTransformService;
import com.santharam.get_fit.users.entity.Users;
import com.santharam.get_fit.users.repository.UsersRepo;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Data
@Transactional
@AllArgsConstructor
@NoArgsConstructor
@Service
@Builder
public class RoutineServiceImp implements RoutineService {

    private RoutineRepo routineRepo;
    private UsersRepo usersRepo;
    private RoutineTransformService routineTransformService;

    @Override
    public Routine createRoutine(RoutineRequestDto routineRequestDto) {
        Users users = null;
        if (routineRequestDto.getUserId() != null) {
            users = usersRepo.findById(routineRequestDto.getUserId())
                    .orElseThrow(() -> new RuntimeException("User not found."));
        }

        Routine routine = routineTransformService.toEntity(routineRequestDto);
        routine.setUsers(users);

        return routineRepo.save(routine);
    }

    @Override
    public Routine updateRoutine(Long id, RoutineRequestDto routineRequestDto) {
        Routine existing = routineRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Routine not found."));

        if (routineRequestDto.getRoutineName() != null) existing.setRoutineName(routineRequestDto.getRoutineName());
        if (routineRequestDto.getGoal() != null) existing.setGoal(routineRequestDto.getGoal());
        if (routineRequestDto.getDaysPerWeek() != null) existing.setDaysPerWeek(routineRequestDto.getDaysPerWeek());
        if (routineRequestDto.getDescription() != null) existing.setDescription(routineRequestDto.getDescription());
        if (routineRequestDto.getActive() != null) existing.setActive(routineRequestDto.getActive());

        if (routineRequestDto.getUserId() != null) {
            if (existing.getUsers() == null || !routineRequestDto.getUserId().equals(existing.getUsers().getId())) {
                Users users = usersRepo.findById(routineRequestDto.getUserId())
                        .orElseThrow(() -> new RuntimeException("User not found."));
                existing.setUsers(users);
            }
        }

        return routineRepo.save(existing);
    }

    @Override
    public Routine getRoutineById(Long id) {
        return routineRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Routine not found."));
    }

    @Override
    public List<Routine> getAllRoutines() {
        return routineRepo.findAll();
    }

    @Override
    public List<Routine> getRoutinesByUserId(Long userId) {
        return routineRepo.findAll()
                .stream()
                .filter(r -> r.getUsers() != null && r.getUsers().getId().equals(userId))
                .toList();
    }

    @Override
    public void deleteRoutine(Long id) {
        Routine existing = routineRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Routine not found."));
        existing.setActive(false);
        routineRepo.save(existing);
    }
}
