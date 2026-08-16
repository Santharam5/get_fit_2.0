package com.santharam.get_fit.routine.transform;

import com.santharam.get_fit.routine.dto.RoutineRequestDto;
import com.santharam.get_fit.routine.entity.Routine;
import com.santharam.get_fit.users.entity.Users;
import org.springframework.stereotype.Component;

@Component
public class RoutineTransformService {

    public Routine toEntity(RoutineRequestDto dto) {
        if (dto == null) {
            return null;
        }

        Users users = null;
        if (dto.getUserId() != null) {
            users = Users.builder().id(dto.getUserId()).build();
        }

        return Routine.builder()
                .routineName(dto.getRoutineName())
                .goal(dto.getGoal())
                .daysPerWeek(dto.getDaysPerWeek())
                .description(dto.getDescription())
                .active(dto.getActive() == null || dto.getActive())
                .users(users)
                .build();
    }
}
