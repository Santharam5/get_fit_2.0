package com.santharam.get_fit.gymEquipment.repository;

import com.santharam.get_fit.gym.entity.Gym;
import com.santharam.get_fit.gymEquipment.entity.GymEquipment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GymEquipmentRepo extends JpaRepository<GymEquipment,Long> {
    List<GymEquipment> findByGymId(Long gymId);
    List<GymEquipment> findByEquipmentId(Long equipmentId);
    boolean existsByGymIdAndEquipmentId(Long gymId,Long equipment);
    GymEquipment findByGymIdAndEquipmentId(Long gymId,Long equipmentId);
}
