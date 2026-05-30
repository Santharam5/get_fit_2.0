package com.santharam.get_fit.gymEquipment.transform;

import com.santharam.get_fit.equipment.entity.Equipment;
import com.santharam.get_fit.gym.entity.Gym;
import com.santharam.get_fit.gymEquipment.dto.GymEquipmentRequestDto;
import com.santharam.get_fit.gymEquipment.entity.GymEquipment;
import org.springframework.stereotype.Service;

@Service
public class GymEquipmentTransformService {
public GymEquipment toEntity(GymEquipmentRequestDto request, Gym gym, Equipment equipment){
return GymEquipment.builder()
        .gym(gym)
        .equipment(equipment)
        .quantity(request.getQuantity())
        .available(request.getAvailable())
        .build();
}
}
