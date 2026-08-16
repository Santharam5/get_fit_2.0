package com.santharam.get_fit.routine.repository;

import com.santharam.get_fit.routine.entity.Routine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoutineRepo extends JpaRepository<Routine, Long> {
}
