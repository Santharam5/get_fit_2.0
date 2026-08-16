package com.santharam.get_fit.routineExercise.controllers;

import com.santharam.get_fit.routineExercise.dto.RoutineExerciseRequestDto;
import com.santharam.get_fit.routineExercise.entity.RoutineExercise;
import com.santharam.get_fit.routineExercise.service.RoutineExerciseService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/routine-exercise")
public class RoutineExerciseController {

    @Autowired
    private RoutineExerciseService routineExerciseService;

    @PostMapping("/create")
    public ResponseEntity<RoutineExercise> create(@Valid @RequestBody RoutineExerciseRequestDto requestDto) {
        return ResponseEntity.status(201).body(routineExerciseService.createRoutineExercise(requestDto));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<RoutineExercise> update(@PathVariable Long id, @Valid @RequestBody RoutineExerciseRequestDto requestDto) {
        return ResponseEntity.ok(routineExerciseService.updateRoutineExercise(id, requestDto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<RoutineExercise> getById(@PathVariable Long id) {
        return ResponseEntity.ok(routineExerciseService.getRoutineExerciseById(id));
    }

    @GetMapping("/routine/{routineId}")
    public ResponseEntity<List<RoutineExercise>> getByRoutineId(@PathVariable Long routineId) {
        return ResponseEntity.ok(routineExerciseService.getRoutineExercisesByRoutineId(routineId));
    }

    @GetMapping("/exists/{routineId}/{exerciseId}")
    public ResponseEntity<Boolean> exists(@PathVariable Long routineId, @PathVariable Long exerciseId) {
        return ResponseEntity.ok(routineExerciseService.existsByRoutineIdAndExerciseId(routineId, exerciseId));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<RoutineExercise> delete(@PathVariable Long id) {
        routineExerciseService.deleteRoutineExercise(id);
        return ResponseEntity.ok(routineExerciseService.getRoutineExerciseById(id));
    }
}
