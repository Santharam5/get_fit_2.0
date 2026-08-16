package com.santharam.get_fit.routineExercise.service;

import com.santharam.get_fit.routineExercise.dto.RoutineExerciseRequestDto;
import com.santharam.get_fit.routineExercise.entity.RoutineExercise;

import java.util.List;

public interface RoutineExerciseService {
    RoutineExercise createRoutineExercise(RoutineExerciseRequestDto requestDto);
    RoutineExercise updateRoutineExercise(Long id, RoutineExerciseRequestDto requestDto);

    RoutineExercise getRoutineExerciseById(Long id);

    List<RoutineExercise> getRoutineExercisesByRoutineId(Long routineId);

    void deleteRoutineExercise(Long id);

    boolean existsByRoutineIdAndExerciseId(Long routineId, Long exerciseId);
}
