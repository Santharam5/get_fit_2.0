package com.santharam.get_fit.equipment.repository;

import com.santharam.get_fit.equipment.entity.Equipment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EquipmentRepo extends JpaRepository<Equipment,Long> {

}
