package com.santharam.get_fit.routineExercise.serviceImplementation;

import com.santharam.get_fit.exercise.entity.Exercise;
import com.santharam.get_fit.exercise.repository.ExerciseRepo;
import com.santharam.get_fit.routine.entity.Routine;
import com.santharam.get_fit.routine.repository.RoutineRepo;
import com.santharam.get_fit.routineExercise.dto.RoutineExerciseRequestDto;
import com.santharam.get_fit.routineExercise.entity.RoutineExercise;
import com.santharam.get_fit.routineExercise.repository.RoutineExerciseRepo;
import com.santharam.get_fit.routineExercise.service.RoutineExerciseService;
import com.santharam.get_fit.routineExercise.transform.RoutineExerciseTransformService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Data
@Transactional
@AllArgsConstructor
@NoArgsConstructor
@Service
@Builder
public class RoutineExerciseServiceImp implements RoutineExerciseService {
    @Autowired
    private RoutineExerciseRepo routineExerciseRepo;
    @Autowired
    private RoutineRepo routineRepo;
    @Autowired
    private ExerciseRepo exerciseRepo;
    @Autowired
    private RoutineExerciseTransformService routineExerciseTransformService;

    @Override
    public RoutineExercise createRoutineExercise(RoutineExerciseRequestDto requestDto) {
        Routine routine = routineRepo.findById(requestDto.getRoutineId())
                .orElseThrow(() -> new RuntimeException("Routine not found."));

        Exercise exercise = exerciseRepo.findById(requestDto.getExerciseId())
                .orElseThrow(() -> new RuntimeException("Exercise not found."));

        if (routineExerciseRepo.existsByRoutineIdAndExerciseId(routine.getId(), exercise.getId())) {
            throw new RuntimeException("Routine already contains this exercise.");
        }

        RoutineExercise routineExercise = routineExerciseTransformService.toEntity(requestDto);
        routineExercise.setRoutine(routine);
        routineExercise.setExercise(exercise);

        return routineExerciseRepo.save(routineExercise);
    }

    @Override
    public RoutineExercise updateRoutineExercise(Long id, RoutineExerciseRequestDto requestDto) {
        RoutineExercise existing = routineExerciseRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("RoutineExercise not found."));

        if (requestDto.getRoutineId() != null && !requestDto.getRoutineId().equals(existing.getRoutine().getId())) {
            Routine routine = routineRepo.findById(requestDto.getRoutineId())
                    .orElseThrow(() -> new RuntimeException("Routine not found."));
            existing.setRoutine(routine);
        }

        if (requestDto.getExerciseId() != null && !requestDto.getExerciseId().equals(existing.getExercise().getId())) {
            Exercise exercise = exerciseRepo.findById(requestDto.getExerciseId())
                    .orElseThrow(() -> new RuntimeException("Exercise not found."));
            existing.setExercise(exercise);
        }
        if (requestDto.getSets() != null) existing.setSets(requestDto.getSets());
        if (requestDto.getReps() != null) existing.setReps(requestDto.getReps());
        if (requestDto.getWeightKg() != null) existing.setWeightKg(requestDto.getWeightKg());
        if (requestDto.getRestTimeSeconds() != null) existing.setRestTimeSeconds(requestDto.getRestTimeSeconds());
        if (requestDto.getDurationMinutes() != null) existing.setDurationMinutes(requestDto.getDurationMinutes());
        if (requestDto.getExerciseOrder() != null) existing.setExerciseOrder(requestDto.getExerciseOrder());
        if (requestDto.getIsActive() != null) existing.setIsActive(requestDto.getIsActive());

        return routineExerciseRepo.save(existing);
    }

    @Override
    public RoutineExercise getRoutineExerciseById(Long id) {
        return routineExerciseRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("RoutineExercise not found."));
    }

    @Override
    public List<RoutineExercise> getRoutineExercisesByRoutineId(Long routineId) {
        return routineExerciseRepo.findByRoutineIdOrderByExerciseOrderAsc(routineId);
    }

    @Override
    public void deleteRoutineExercise(Long id) {
        RoutineExercise existing = routineExerciseRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("RoutineExercise not found."));
        existing.setIsActive(false);
        routineExerciseRepo.save(existing);
    }

    @Override
    public boolean existsByRoutineIdAndExerciseId(Long routineId, Long exerciseId) {
        return routineExerciseRepo.existsByRoutineIdAndExerciseId(routineId, exerciseId);
    }

    // repository-like methods exposed by the service implementation
    public List<RoutineExercise> findByRoutineId(Long routineId) {
        return routineExerciseRepo.findByRoutineId(routineId);
    }

    public List<RoutineExercise> findByRoutineIdAndIsActiveTrue(Long routineId) {
        return routineExerciseRepo.findByRoutineIdAndIsActiveTrue(routineId);
    }

    public List<RoutineExercise> findByRoutineIdOrderByExerciseOrderAsc(Long routineId) {
        return routineExerciseRepo.findByRoutineIdOrderByExerciseOrderAsc(routineId);
    }

    public List<RoutineExercise> findByExerciseId(Long exerciseId) {
        return routineExerciseRepo.findByExerciseId(exerciseId);
    }

    public Optional<RoutineExercise> findByRoutineIdAndExerciseId(Long routineId, Long exerciseId) {
        return routineExerciseRepo.findByRoutineIdAndExerciseId(routineId, exerciseId);
    }
}
