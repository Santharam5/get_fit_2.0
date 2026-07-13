package com.santharam.get_fit.gym.controllers;

import com.santharam.get_fit.gym.dto.GymRequestDto;
import com.santharam.get_fit.gym.entity.Gym;
import com.santharam.get_fit.gym.service.GymService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/gym")
public class GymController {
    @Autowired
    GymService gymService;
    @PostMapping("/create")
    public ResponseEntity<Gym> creatingGym(@Valid @RequestBody GymRequestDto gymRequestDto){
        Gym gym=gymService.createGym(gymRequestDto);
        return ResponseEntity.status(201).body(gym);
    }
    @GetMapping("/getAll")
    public ResponseEntity<List<Gym>> gettingAllGym(){
        List<Gym> gym=gymService.getAllGyms();
        return ResponseEntity.status(200).body(gym);
    }
    @GetMapping("/get")
    public ResponseEntity<Gym> gettingSingleGym(Long id){
        Gym gym=gymService.getGym(id);
        return ResponseEntity.status(200).body(gym);
    }

}
