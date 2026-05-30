package com.santharam.get_fit.equipment.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.santharam.get_fit.gymEquipment.entity.GymEquipment;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Equipment")
public class Equipment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    // Equipment name
    @Column(nullable = false,length = 150)
    private String name;
    //Equipment description
    @Column(nullable = false,length = 500)
    private String description;
    //Equipment category
    @Column(nullable = false,length = 150)
    private String category;
    // one to many into Gym Equipment Entity
    @JsonManagedReference
    @OneToMany(mappedBy = "equipment",cascade = CascadeType.ALL)
    private List<GymEquipment> equipments;
}
