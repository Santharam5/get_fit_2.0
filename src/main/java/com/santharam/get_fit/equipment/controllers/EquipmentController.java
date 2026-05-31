package com.santharam.get_fit.equipment.controllers;

import com.santharam.get_fit.equipment.dto.EquipmentRequestDto;
import com.santharam.get_fit.equipment.entity.Equipment;
import com.santharam.get_fit.equipment.service.EquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/equipment")
public class EquipmentController {
    @Autowired
    EquipmentService equipmentService;
    @PostMapping("/create")
    public ResponseEntity<Equipment> createEquipment(@RequestBody EquipmentRequestDto request){
        Equipment equipment=equipmentService.CreateEquipment(request);
        return ResponseEntity.status(201).body(equipment);
    }
    @GetMapping("/getall")
    public ResponseEntity<List<Equipment>> getAllEquipment(){
        List<Equipment> equipmentList=equipmentService.getAllEquipment();
        return ResponseEntity.status(200).body(equipmentList);
    }
    @GetMapping("/getbyid")
    public ResponseEntity<Equipment> getEquipmentById(@RequestParam Long id){
        Equipment equipment=equipmentService.getEquipment(id);
        return ResponseEntity.status(200).body(equipment);
    }
}
