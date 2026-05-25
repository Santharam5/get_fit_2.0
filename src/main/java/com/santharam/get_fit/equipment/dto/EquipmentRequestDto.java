package com.santharam.get_fit.equipment.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EquipmentRequestDto {
    // Equipment name
    private String name;
    //Equipment description
    private String description;
    //Equipment category
    private String category;
}
