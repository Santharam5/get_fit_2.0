package com.santharam.get_fit.gym.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.santharam.get_fit.gymEquipment.entity.GymEquipment;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "Gym")
public class Gym {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    // Gym name
    @Column(nullable = false,length = 300)
    private String name;
    //Gym location
    @Column(nullable = false,length = 500)
    private String location;
    //Gym rating
    @Column(nullable = false,length = 2)
    private Integer rating;
    //Gym description
    @Column(nullable = false,length = 1000)
    private String description;
    //one to many into Gym Equipment Entity
    @JsonManagedReference
    @OneToMany(mappedBy = "gym",cascade = CascadeType.ALL)
    private List<GymEquipment> gymEquipments;
}
