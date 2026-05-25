package com.santharam.get_fit.gymEquipment.service;

import com.santharam.get_fit.gymEquipment.dto.GymEquipmentRequestDto;
import com.santharam.get_fit.gymEquipment.entity.GymEquipment;

import java.util.List;

public interface GymEquimentService {
public GymEquipment addEquipmentToGym(GymEquipmentRequestDto request);
public List<GymEquipment> getEquipmentByGym(Long gymId);
public GymEquipment updateQuantity(Long gymEquipmentId,Integer quantity);
public GymEquipment updateAvailability(Long gymEquipmentId, Boolean available);
public void removeEquipment(Long gymEquipmentId);
}
