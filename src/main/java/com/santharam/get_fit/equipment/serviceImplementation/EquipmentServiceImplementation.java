package com.santharam.get_fit.equipment.serviceImplementation;

import com.santharam.get_fit.equipment.dto.EquipmentRequestDto;
import com.santharam.get_fit.equipment.entity.Equipment;
import com.santharam.get_fit.equipment.repository.EquipmentRepo;
import com.santharam.get_fit.equipment.service.EquipmentService;
import com.santharam.get_fit.equipment.transform.EquipmentTransformService;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EquipmentServiceImplementation implements EquipmentService {
    @Autowired
    EquipmentTransformService equipmentTransformService;
    @Autowired
    EquipmentRepo equipmentRepo;

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
        return equipmentRepo.findById(id).orElseThrow(()->new RuntimeException("Equipment not found"));
    }
}
