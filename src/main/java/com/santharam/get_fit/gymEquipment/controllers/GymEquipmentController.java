package com.santharam.get_fit.gymEquipment.controllers;

import com.santharam.get_fit.gymEquipment.dto.GymEquipmentRequestDto;
import com.santharam.get_fit.gymEquipment.entity.GymEquipment;
import com.santharam.get_fit.gymEquipment.service.GymEquimentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/gymequipment")
public class GymEquipmentController {
    @Autowired
    GymEquimentService  gymEquimentService;
    @PostMapping("/addequimenttogym")
    public ResponseEntity<GymEquipment> addEquipmentToGym(@RequestBody GymEquipmentRequestDto request){
        GymEquipment gymEquipment= gymEquimentService.addEquipmentToGym(request);
        return ResponseEntity.status(201).body(gymEquipment);
    }
    @GetMapping("/gym/{gymId}")
    public ResponseEntity<List<GymEquipment>> getEquipmentById(@RequestParam Long gymId){
        List<GymEquipment> gymEquipmentList= gymEquimentService.getEquipmentByGym(gymId);
        return ResponseEntity.status(200).body(gymEquipmentList);
    }
    @PutMapping("/{gymEquipmentId}/quantity")
    public ResponseEntity<GymEquipment> updateQuantity(@RequestParam Long gymEquipmentId,@RequestParam Integer quantity){
        GymEquipment gymEquipment= gymEquimentService.updateQuantity(gymEquipmentId,quantity);
        return ResponseEntity.status(200).body(gymEquipment);
    }
    @PutMapping("/{gymEquipmentId}/availablity")
    public ResponseEntity<GymEquipment> updateAvailability(@RequestParam Long gymEquipmentId,@RequestParam Boolean available){
        GymEquipment gymEquipment=gymEquimentService.updateAvailability(gymEquipmentId,available);
        return ResponseEntity.status(200).body(gymEquipment);
    }
    @DeleteMapping("/{gymEquipmentId}")
    public void removeEquipment(@RequestParam Long gymEquipmentId){
        gymEquimentService.removeEquipment(gymEquipmentId);
    }
}
