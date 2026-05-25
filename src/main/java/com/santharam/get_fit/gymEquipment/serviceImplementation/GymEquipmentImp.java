package com.santharam.get_fit.gymEquipment.serviceImplementation;

import com.santharam.get_fit.equipment.entity.Equipment;
import com.santharam.get_fit.equipment.repository.EquipmentRepo;
import com.santharam.get_fit.gym.entity.Gym;
import com.santharam.get_fit.gym.repository.GymRepo;
import com.santharam.get_fit.gymEquipment.dto.GymEquipmentRequestDto;
import com.santharam.get_fit.gymEquipment.entity.GymEquipment;
import com.santharam.get_fit.gymEquipment.repository.GymEquipmentRepo;
import com.santharam.get_fit.gymEquipment.service.GymEquimentService;
import com.santharam.get_fit.gymEquipment.transform.GymEquipmentTransformService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service

public class GymEquipmentImp implements GymEquimentService {
    @Autowired
    GymEquipmentRepo gymEquipmentRepo;
    @Autowired
    GymEquipmentTransformService gymEquipmentTransformService;
    @Autowired
    GymRepo gymRepo;
    @Autowired
    EquipmentRepo equipmentRepo;
    @Override
    public GymEquipment addEquipmentToGym(GymEquipmentRequestDto request) {
        boolean alreadyExists=gymEquipmentRepo.existsByGymIdAndEquipmentId(request.getGymId(), request.getEquipmentId());
        if(alreadyExists){
            throw  new RuntimeException("Equipment already exists in the gym");
        }else {
            Gym gym = gymRepo.findById(request.getGymId()).orElseThrow(() ->  new RuntimeException("Gym not found"));
            Equipment equipment=equipmentRepo.findById(request.getEquipmentId()).orElseThrow(()->new RuntimeException("Equipment not found"));
            GymEquipment gymEquipment=gymEquipmentTransformService.toEntity(request,gym,equipment);
            return gymEquipmentRepo.save(gymEquipment);
        }
    }

    @Override
    public List<GymEquipment> getEquipmentByGym(Long gymId) {
        return gymEquipmentRepo.findByGymId(gymId);
    }

    @Override
    public GymEquipment updateQuantity(Long gymEquipmentId,Integer quantity) {
        GymEquipment gymEquipment=gymEquipmentRepo.findById(gymEquipmentId).orElseThrow(()->new RuntimeException("Gym Equipment Not Found"));
        gymEquipment.setQuantity(quantity);
        return gymEquipmentRepo.save(gymEquipment);
    }

    @Override
    public GymEquipment updateAvailability(Long gymEquipmentId, Boolean available) {
        GymEquipment gymEquipment =
                gymEquipmentRepo.findById(
                        gymEquipmentId
                ).orElseThrow(() ->
                        new RuntimeException(
                                "Gym equipment not found"
                        ));

        gymEquipment.setAvailable(available);

        return gymEquipmentRepo.save(
                gymEquipment);
    }

    @Override
    public void removeEquipment(Long gymEquipmentId) {
            gymEquipmentRepo.deleteById(gymEquipmentId);
    }
}
