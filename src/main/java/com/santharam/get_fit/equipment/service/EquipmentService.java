package com.santharam.get_fit.equipment.service;

import com.santharam.get_fit.equipment.dto.EquipmentRequestDto;
import com.santharam.get_fit.equipment.entity.Equipment;

import java.util.List;

public interface
EquipmentService {
    public Equipment CreateEquipment(EquipmentRequestDto equipmentRequestDto);
    public List<Equipment> getAllEquipment();
    public Equipment getEquipment(Long id);
}
