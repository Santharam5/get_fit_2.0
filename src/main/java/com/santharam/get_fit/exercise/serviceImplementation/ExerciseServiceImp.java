package com.santharam.get_fit.exercise.serviceImplementation;

import com.santharam.get_fit.equipment.entity.Equipment;
import com.santharam.get_fit.equipment.repository.EquipmentRepo;
import com.santharam.get_fit.exercise.dto.ExerciseRequestDto;
import com.santharam.get_fit.exercise.entity.Exercise;
import com.santharam.get_fit.exercise.repository.ExerciseRepo;
import com.santharam.get_fit.exercise.service.ExerciseService;
import com.santharam.get_fit.exercise.transform.ExerciseTransformService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Data
@Transactional
@AllArgsConstructor
@NoArgsConstructor
@Service
@Builder


public class ExerciseServiceImp implements ExerciseService {
    @Autowired
    ExerciseRepo exerciseRepo;
    @Autowired
    EquipmentRepo equipmentRepo;
    @Autowired
    ExerciseTransformService exerciseTransformService;
    /**
     * @param exerciseRequestDto
     * @return
     */
    @Override
    public ExerciseRequestDto createExercise(ExerciseRequestDto exerciseRequestDto) {
        if (exerciseRepo.existsByExerciseNameIgnoreCase(
                exerciseRequestDto.getExerciseName())) {

            throw new RuntimeException("Exercise already exists.");
        }

        Equipment equipment = null;

        if (exerciseRequestDto.getEquipmentId() != null) {

            equipment = equipmentRepo
                    .findById(exerciseRequestDto.getEquipmentId())
                    .orElseThrow(() ->
                            new RuntimeException("Equipment not found."));
        }

        Exercise exercise = exerciseTransformService.toEntity(
                exerciseRequestDto,
                equipment
        );

        Exercise savedExercise = exerciseRepo.save(exercise);

        return exerciseTransformService.convertToDTO(savedExercise);
    }

    /**
     * @param id
     * @param exerciseRequestDto
     * @return
     */
    @Override
    public ExerciseRequestDto updateExercise(Long id, ExerciseRequestDto exerciseRequestDto) {
        Exercise exercise = exerciseRepo.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Exercise not found."));

        Equipment equipment = null;

        if (exerciseRequestDto.getEquipmentId() != null) {

            equipment = equipmentRepo
                    .findById(exerciseRequestDto.getEquipmentId())
                    .orElseThrow(() ->
                            new RuntimeException("Equipment not found."));
        }

        exercise.setExerciseName(exerciseRequestDto.getExerciseName());
        exercise.setMuscleGroup(exerciseRequestDto.getMuscleGroup());
        exercise.setDifficulty(exerciseRequestDto.getDifficulty());
        exercise.setDescription(exerciseRequestDto.getDescription());
        exercise.setCaloriesBurnPerSet(
                exerciseRequestDto.getCaloriesBurnPerSet());

        exercise.setIsActive(exerciseRequestDto.getIsActive());

        exercise.setEquipment(equipment);

        Exercise updatedExercise = exerciseRepo.save(exercise);

        return exerciseTransformService.convertToDTO(updatedExercise);
    }

    /**
     * @param id
     * @return
     */
    @Override
    public ExerciseRequestDto getExerciseById(Long id) {
        Exercise exercise = exerciseRepo.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Exercise not found."));

        return exerciseTransformService.convertToDTO(exercise);
    }

    /**
     * @return
     */
    @Override
    public List<ExerciseRequestDto> getAllExercises() {
        return exerciseRepo.findByIsActiveTrue()
                .stream()
                .map(exerciseTransformService::convertToDTO)
                .toList();
    }

    /**
     * @param exerciseId
     */
    @Override
    public void deleteExercise(Long exerciseId) {
        Exercise exercise = exerciseRepo.findById(exerciseId)
                .orElseThrow(() ->
                        new RuntimeException("Exercise not found."));

        exercise.setIsActive(false);

        exerciseRepo.save(exercise);
    }
}
