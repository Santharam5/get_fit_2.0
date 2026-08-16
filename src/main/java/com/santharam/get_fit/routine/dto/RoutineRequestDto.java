package com.santharam.get_fit.routine.dto;

import com.santharam.get_fit.routine.enums.Goal;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RoutineRequestDto {

    @NotBlank(message = "Routine name is required")
    @Size(min = 3, max = 100, message = "Routine name must be between 3 and 100 characters")
    private String routineName;

    @NotNull(message = "Goal is required")
    private Goal goal;

    @Min(value = 1, message = "Minimum days is 1")
    @Max(value = 7, message = "Maximum days is 7")
    private Integer daysPerWeek;

    @Size(max = 500)
    private String description;

    private Boolean active = true;

    private Long userId;
}
