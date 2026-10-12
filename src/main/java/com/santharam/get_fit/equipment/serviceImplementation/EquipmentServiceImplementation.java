package com.santharam.get_fit.equipment.serviceImplementation;

import com.santharam.get_fit.GlobalExceptionHandler.HandleEntityAlreadyExistsException;
import com.santharam.get_fit.GlobalExceptionHandler.ResourceNotFoundException;
import com.santharam.get_fit.equipment.dto.EquipmentRequestDto;
import com.santharam.get_fit.equipment.entity.Equipment;
import com.santharam.get_fit.equipment.repository.EquipmentRepo;
import com.santharam.get_fit.equipment.service.EquipmentService;
import com.santharam.get_fit.equipment.transform.EquipmentTransformService;
import com.santharam.get_fit.exercise.repository.ExerciseRepo;
import com.santharam.get_fit.gymEquipment.repository.GymEquipmentRepo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Service
public class EquipmentServiceImplementation implements EquipmentService {
    @Autowired
    EquipmentTransformService equipmentTransformService;
    @Autowired
    EquipmentRepo equipmentRepo;
    @Autowired
    GymEquipmentRepo gymEquipmentRepo;
    @Autowired
    ExerciseRepo exerciseRepo;

    @Override
    public Equipment CreateEquipment(EquipmentRequestDto equipmentRequestDto) {
        Equipment equipment=equipmentTransformService.toEntity(equipmentRequestDto);
        return equipmentRepo.save(equipment);
    }

    @Override
    public List<Equipment> getAllEquipment() {
        return equipmentRepo.findAll();
    }

    @Override
    public Equipment getEquipment(Long id) {
        return equipmentRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Equipment not found "+id));
    }

    @Override
    public Equipment updateEquipment(Long id, EquipmentRequestDto equipmentRequestDto) {
        Equipment existingEquipment = equipmentRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Equipment not found "+id));

        existingEquipment.setName(equipmentRequestDto.getName());
        existingEquipment.setDescription(equipmentRequestDto.getDescription());
        existingEquipment.setCategory(equipmentRequestDto.getCategory());

        return equipmentRepo.save(existingEquipment);
    }

    @Override
    public void deleteEquipment(Long id) {
        Equipment existingEquipment = equipmentRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Equipment not found "+id));

        var gymEquipmentAssignments = gymEquipmentRepo.findByEquipmentId(id);
        if (gymEquipmentAssignments != null && !gymEquipmentAssignments.isEmpty()) {
            throw new HandleEntityAlreadyExistsException("Cannot delete equipment with existing gym assignments");
        }
        var exercises = exerciseRepo.findByEquipmentId(id);

        if (exercises != null && !exercises.isEmpty()) {
            throw new HandleEntityAlreadyExistsException(
                    "Cannot delete equipment with existing exercises"
            );
        }

        equipmentRepo.delete(existingEquipment);
    }
}
