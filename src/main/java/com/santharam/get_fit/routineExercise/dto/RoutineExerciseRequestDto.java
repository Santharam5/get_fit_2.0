package com.santharam.get_fit.routineExercise.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RoutineExerciseRequestDto {

    @NotNull(message = "Routine id is required")
    private Long routineId;

    @NotNull(message = "Exercise id is required")
    private Long exerciseId;

    @NotNull(message = "Sets is required")
    @Min(value = 1, message = "Sets must be at least 1")
    @Max(value = 20, message = "Sets cannot exceed 20")
    private Integer sets;

    @NotNull(message = "Reps is required")
    @Min(value = 1, message = "Reps must be at least 1")
    @Max(value = 100, message = "Reps cannot exceed 100")
    private Integer reps;

    @Min(value = 0, message = "Weight cannot be negative")
    private Double weightKg;

    @Min(value = 0, message = "Rest time cannot be negative")
    private Integer restTimeSeconds;

    @Min(value = 1, message = "Duration must be at least 1 minute")
    private Integer durationMinutes;

    private Integer exerciseOrder;

    private Boolean isActive = true;
}
