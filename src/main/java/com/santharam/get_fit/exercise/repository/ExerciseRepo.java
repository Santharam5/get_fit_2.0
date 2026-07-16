package com.santharam.get_fit.exercise.repository;

import com.santharam.get_fit.exercise.entity.Exercise;
import com.santharam.get_fit.exercise.enums.Difficulty;
import com.santharam.get_fit.exercise.enums.MuscleGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ExerciseRepo extends JpaRepository<Exercise, Long> {
    Optional<Exercise> findByExerciseNameIgnoreCase(String exerciseName);

    boolean existsByExerciseNameIgnoreCase(String exerciseName);

    List<Exercise> findByMuscleGroup(MuscleGroup muscleGroup);

    List<Exercise> findByDifficulty(Difficulty difficulty);

    List<Exercise> findByIsActiveTrue();

    List<Exercise> findByEquipmentId(Long equipmentId);
}
