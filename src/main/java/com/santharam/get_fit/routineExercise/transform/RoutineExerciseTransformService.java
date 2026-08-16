package com.santharam.get_fit.routineExercise.transform;

import com.santharam.get_fit.exercise.entity.Exercise;
import com.santharam.get_fit.routine.entity.Routine;
import com.santharam.get_fit.routineExercise.dto.RoutineExerciseRequestDto;
import com.santharam.get_fit.routineExercise.entity.RoutineExercise;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Component
public class RoutineExerciseTransformService {

    public RoutineExercise toEntity(RoutineExerciseRequestDto dto) {
        if (dto == null) {
            return null;
        }

        Routine routine = Routine.builder().id(dto.getRoutineId()).build();

        Exercise exercise = new Exercise();
        exercise.setId(dto.getExerciseId());

        return RoutineExercise.builder()
                .routine(routine)
                .exercise(exercise)
                .sets(dto.getSets())
                .reps(dto.getReps())
                .weightKg(dto.getWeightKg())
                .restTimeSeconds(dto.getRestTimeSeconds())
                .durationMinutes(dto.getDurationMinutes())
                .exerciseOrder(dto.getExerciseOrder())
                .isActive(dto.getIsActive() == null || dto.getIsActive())
                .build();
    }
}
