package com.santharam.get_fit.routine.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.santharam.get_fit.routine.enums.Goal;
import com.santharam.get_fit.routineExercise.entity.RoutineExercise;
import com.santharam.get_fit.users.entity.Users;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Table(name = "routine")
public class Routine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Routine name is required")
    @Size(min=3,max=100,message = "Routine name must be between 3 and 100 characters")
    @Column(nullable = false,length = 100)
    private String routineName;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Goal goal;
    @Min(value = 1, message = "Minimum days is 1")
    @Max(value = 7, message = "Maximum days is 7")
    private Integer daysPerWeek;
    @Size(max = 500)
    @Column(length = 500)
    private String description;
    @Builder.Default
    private Boolean active = true;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private Users users;
    @OneToMany(mappedBy = "routine",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    @JsonManagedReference
    private List<RoutineExercise> routineExercises;
}
