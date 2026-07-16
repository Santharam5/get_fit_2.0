package com.santharam.get_fit.exercise.dto;

import com.santharam.get_fit.exercise.enums.Difficulty;
import com.santharam.get_fit.exercise.enums.MuscleGroup;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ExerciseRequestDto {
    @NotBlank(message = "Exercise name is required")
    @Size(min = 3, max = 100)
    private String exerciseName;
    @NotNull(message = "Muscle group is required")
    private MuscleGroup muscleGroup;
    @NotNull(message = "Difficulty is required")
    private Difficulty difficulty;
    @Size(max = 500)
    private String description;
    @Min(1)
    @Max(500)
    private Integer caloriesBurnPerSet;
    private Boolean isActive = true;
    private Long equipmentId;
    private String equipmentName;
}
