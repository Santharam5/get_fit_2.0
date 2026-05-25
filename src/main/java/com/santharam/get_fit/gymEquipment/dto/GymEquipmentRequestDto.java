package com.santharam.get_fit.gymEquipment.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GymEquipmentRequestDto {
    private Long gymId;
    private Long equipmentId;
    private Integer quantity;
    private Boolean available;
}
