package com.santharam.get_fit.gymEquipment.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.santharam.get_fit.equipment.entity.Equipment;
import com.santharam.get_fit.gym.entity.Gym;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "GymEquipment")
public class GymEquipment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    // many to one from gym
    @ManyToOne
    @JsonBackReference
    @JoinColumn(name="gym_id")
    private Gym gym;
    //many to one from equipment
    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "equipment_id")
    private Equipment equipment;
    //GymEquipment Quantity
    @Column(nullable = false,length = 1000)
    private Integer quantity;
    //GymEquipment Available
    @Column(nullable = false)
    private Boolean available;




}
