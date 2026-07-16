package com.santharam.get_fit.exercise.controllers;

import com.santharam.get_fit.exercise.dto.ExerciseRequestDto;
import com.santharam.get_fit.exercise.entity.Exercise;
import com.santharam.get_fit.exercise.service.ExerciseService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/exercise")
public class ExerciseController {
    @Autowired
    private ExerciseService exerciseService;
    @PostMapping("/create")
    public ResponseEntity<ExerciseRequestDto> create(@Valid @RequestBody ExerciseRequestDto exerciseRequestDto) {
        return ResponseEntity.status(201).body(exerciseService.createExercise(exerciseRequestDto));
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<ExerciseRequestDto> update(@PathVariable Long id, @Valid @RequestBody ExerciseRequestDto exerciseRequestDto) {
        return ResponseEntity.status(200).body(exerciseService.updateExercise(id, exerciseRequestDto));
    }
    @GetMapping("/{id}")
    public ResponseEntity<ExerciseRequestDto> getExerciseById(@PathVariable Long id) {
        return ResponseEntity.status(200).body(exerciseService.getExerciseById(id));
    }
    @GetMapping("/all")
    public ResponseEntity<List<ExerciseRequestDto>> getAllExercises() {
        return ResponseEntity.status(200).body(exerciseService.getAllExercises());
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ExerciseRequestDto> deleteById(@PathVariable Long id) {
        exerciseService.deleteExercise(id);
        return ResponseEntity.status(200).body(exerciseService.getExerciseById(id));
    }
}
