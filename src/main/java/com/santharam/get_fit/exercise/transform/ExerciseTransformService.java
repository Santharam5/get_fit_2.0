package com.santharam.get_fit.exercise.transform;

import com.santharam.get_fit.equipment.entity.Equipment;
import com.santharam.get_fit.exercise.dto.ExerciseRequestDto;
import com.santharam.get_fit.exercise.entity.Exercise;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Component
public class ExerciseTransformService {
    public Exercise toEntity(ExerciseRequestDto exerciseRequestDto, Equipment equipment) {
        Exercise exercise = new Exercise();
        exercise.setExerciseName(exerciseRequestDto.getExerciseName());
        exercise.setMuscleGroup(exerciseRequestDto.getMuscleGroup());
        exercise.setDifficulty(exerciseRequestDto.getDifficulty());
        exercise.setDescription(exerciseRequestDto.getDescription());
        exercise.setCaloriesBurnPerSet(exerciseRequestDto.getCaloriesBurnPerSet());
        if (exerciseRequestDto.getIsActive() == null) {
            exercise.setIsActive(true);
        } else {
            exercise.setIsActive(exerciseRequestDto.getIsActive());
        }
        exercise.setEquipment(equipment);
        return exercise;
    }
    /**
     * Convert Entity -> DTO
     */
    public ExerciseRequestDto convertToDTO(Exercise exercise) {

        ExerciseRequestDto dto = new ExerciseRequestDto();

        dto.setExerciseName(exercise.getExerciseName());
        dto.setMuscleGroup(exercise.getMuscleGroup());
        dto.setDifficulty(exercise.getDifficulty());
        dto.setDescription(exercise.getDescription());
        dto.setCaloriesBurnPerSet(exercise.getCaloriesBurnPerSet());
        dto.setIsActive(exercise.getIsActive());

        if (exercise.getEquipment() != null) {

            dto.setEquipmentId(
                    exercise.getEquipment().getId());

            dto.setEquipmentName(
                    exercise.getEquipment().getName());
        }

        return dto;
    }

    /**
     * Update existing entity from DTO
     */
    public void updateEntity(Exercise exercise,
                             ExerciseRequestDto dto,
                             Equipment equipment) {

        exercise.setExerciseName(dto.getExerciseName());
        exercise.setMuscleGroup(dto.getMuscleGroup());
        exercise.setDifficulty(dto.getDifficulty());
        exercise.setDescription(dto.getDescription());
        exercise.setCaloriesBurnPerSet(dto.getCaloriesBurnPerSet());
        if (dto.getIsActive() != null) {
            exercise.setIsActive(dto.getIsActive());
        }

        exercise.setEquipment(equipment);
    }
}
