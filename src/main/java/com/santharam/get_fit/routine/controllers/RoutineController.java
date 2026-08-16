package com.santharam.get_fit.routine.controllers;

import com.santharam.get_fit.routine.dto.RoutineRequestDto;
import com.santharam.get_fit.routine.entity.Routine;
import com.santharam.get_fit.routine.service.RoutineService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/routine")
public class RoutineController {

    @Autowired
    private RoutineService routineService;

    @PostMapping("/create")
    public ResponseEntity<Routine> create(@Valid @RequestBody RoutineRequestDto requestDto) {
        return ResponseEntity.status(201).body(routineService.createRoutine(requestDto));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Routine> update(@PathVariable Long id, @Valid @RequestBody RoutineRequestDto requestDto) {
        return ResponseEntity.ok(routineService.updateRoutine(id, requestDto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Routine> getById(@PathVariable Long id) {
        return ResponseEntity.ok(routineService.getRoutineById(id));
    }

    @GetMapping("/all")
    public ResponseEntity<List<Routine>> getAll() {
        return ResponseEntity.ok(routineService.getAllRoutines());
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Routine>> getByUser(@PathVariable Long userId) {
        return ResponseEntity.ok(routineService.getRoutinesByUserId(userId));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Routine> delete(@PathVariable Long id) {
        routineService.deleteRoutine(id);
        return ResponseEntity.ok(routineService.getRoutineById(id));
    }
}
