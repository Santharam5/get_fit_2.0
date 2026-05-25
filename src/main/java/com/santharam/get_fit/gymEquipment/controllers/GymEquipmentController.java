package com.santharam.get_fit.gymEquipment.controllers;

import com.santharam.get_fit.gymEquipment.dto.GymEquipmentRequestDto;
import com.santharam.get_fit.gymEquipment.entity.GymEquipment;
import com.santharam.get_fit.gymEquipment.service.GymEquimentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/gymequipment")
public class GymEquipmentController {
    @Autowired
    GymEquimentService  gymEquimentService;
    @PostMapping("/addequimenttogym")
    public GymEquipment addEquipmentToGym(@RequestBody GymEquipmentRequestDto request){
        return gymEquimentService.addEquipmentToGym(request);
    }
    @GetMapping("gym/{gymId}")
    public List<GymEquipment> getEquipmentById(@RequestParam Long gymId){
        return gymEquimentService.getEquipmentByGym(gymId);
    }
    @PutMapping("/{gymEquipmentId}/quantity")
    public GymEquipment updateQuantity(@RequestParam Long gymEquipmentId,@RequestParam Integer quantity){
        return gymEquimentService.updateQuantity(gymEquipmentId,quantity);
    }
    @PutMapping("/{gymEquipmentId}/availablity")
    public GymEquipment updateAvailability(@RequestParam Long gymEquipmentId,@RequestParam Boolean available){
        return gymEquimentService.updateAvailability(gymEquipmentId,available);
    }
    @DeleteMapping("/{gymEquipmentId}")
    public void removeEquipment(@RequestParam Long gymEquipmentId){
        gymEquimentService.removeEquipment(gymEquipmentId);
    }
}
