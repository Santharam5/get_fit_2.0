package com.santharam.get_fit.routineExercise.entity;

import com.santharam.get_fit.exercise.entity.Exercise;
import com.santharam.get_fit.routine.entity.Routine;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Table(name = "routine_exercise")
public class RoutineExercise {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="routine_id",nullable = false)
    private Routine routine;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="exercise_id",nullable = false)
    private Exercise exercise;
    @Min(value = 1, message = "Sets must be at least 1")
    @Max(value = 20, message = "Sets cannot exceed 20")
    @Column(nullable = false)
    private Integer sets;
    @Max(value = 100, message = "Reps cannot exceed 100")
    @Column(nullable = false)
    private Integer reps;
    @Min(value = 0, message = "Weight cannot be negative")
    @Column(name = "weight_kg")
    private Double weightKg;
    @Min(value = 0, message = "Rest time cannot be negative")
    @Column(name = "rest_time_seconds")
    private Integer restTimeSeconds;
    @Min(value = 1, message = "Duration must be at least 1 minute")
    @Column(name = "duration_minutes")
    private Integer durationMinutes;
    @Column(name = "exercise_order")
    private Integer exerciseOrder;
    @Column(name = "is_active")
    private Boolean isActive = true;
}
