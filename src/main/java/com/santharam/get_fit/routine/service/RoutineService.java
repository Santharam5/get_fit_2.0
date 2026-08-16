package com.santharam.get_fit.routine.service;

import com.santharam.get_fit.routine.dto.RoutineRequestDto;
import com.santharam.get_fit.routine.entity.Routine;

import java.util.List;

public interface RoutineService {
    Routine createRoutine(RoutineRequestDto routineRequestDto);

    Routine updateRoutine(Long id, RoutineRequestDto routineRequestDto);

    Routine getRoutineById(Long id);

    List<Routine> getAllRoutines();

    List<Routine> getRoutinesByUserId(Long userId);

    void deleteRoutine(Long id);
}
