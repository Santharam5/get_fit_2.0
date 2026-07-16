package com.santharam.get_fit.exercise.service;

import com.santharam.get_fit.exercise.dto.ExerciseRequestDto;

import java.util.List;

public interface ExerciseService {
    ExerciseRequestDto createExercise(ExerciseRequestDto exerciseRequestDto);

    ExerciseRequestDto updateExercise(Long id, ExerciseRequestDto exerciseRequestDto);

    ExerciseRequestDto getExerciseById(Long id);

    List<ExerciseRequestDto> getAllExercises();

    void deleteExercise(Long exerciseId);

}
