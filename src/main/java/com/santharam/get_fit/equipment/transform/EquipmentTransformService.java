package com.santharam.get_fit.equipment.transform;

import com.santharam.get_fit.equipment.dto.EquipmentRequestDto;
import com.santharam.get_fit.equipment.entity.Equipment;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EquipmentTransformService {
    public Equipment toEntity(EquipmentRequestDto equipmentRequestDto){
        return Equipment.builder()
                .name(equipmentRequestDto.getName())
                .description(equipmentRequestDto.getDescription())
                .category(equipmentRequestDto.getCategory())
                .build();
    }
}
