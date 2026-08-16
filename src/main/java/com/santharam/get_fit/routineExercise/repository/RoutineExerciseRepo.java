package com.santharam.get_fit.routineExercise.repository;

import com.santharam.get_fit.routineExercise.entity.RoutineExercise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RoutineExerciseRepo extends JpaRepository<RoutineExercise, Long> {

    List<RoutineExercise> findByRoutineId(Long routineId);

    List<RoutineExercise> findByRoutineIdAndIsActiveTrue(Long routineId);

    List<RoutineExercise> findByRoutineIdOrderByExerciseOrderAsc(Long routineId);

    List<RoutineExercise> findByExerciseId(Long exerciseId);

    Optional<RoutineExercise> findByRoutineIdAndExerciseId(Long routineId, Long exerciseId);

    boolean existsByRoutineIdAndExerciseId(Long routineId, Long exerciseId);
}