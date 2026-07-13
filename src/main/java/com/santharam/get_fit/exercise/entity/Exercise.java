package com.santharam.get_fit.exercise.entity;

import com.santharam.get_fit.equipment.entity.Equipment;
import com.santharam.get_fit.exercise.enums.Difficulty;
import com.santharam.get_fit.exercise.enums.MuscleGroup;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="exercise")
public class Exercise {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="exercise_id")
    private Long id;
    @NotBlank(message = "Exercise name should not be blank")
    @Size(min=3,max=100,message = "Exercise name must be between 3 and 100 characters")
    @Column(name = "exercise_name", nullable = false, unique = true, length = 100)
    private String exerciseName;
    @Enumerated(EnumType.STRING)
    @NotNull(message = "Muscle group is required")
    @Column(name = "muscle_group", nullable = false)
    private MuscleGroup muscleGroup;
    @Enumerated(EnumType.STRING)
    @NotNull(message = "Difficulty is required")
    @Column(name = "difficulty", nullable = false)
    private Difficulty difficulty;
    @Size(max = 500, message = "Description cannot exceed 500 characters")
    @Column(length = 500)
    private String description;
    @Min(value = 1, message = "Calories burned must be greater than 0")
    @Max(value = 500, message = "Calories burned cannot exceed 500")
    @Column(name = "calories_burn_per_set")
    private Integer caloriesBurnPerSet;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "equipment_id")
    private Equipment equipment;
}
