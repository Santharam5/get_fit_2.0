package com.santharam.get_fit.gymEquipment.serviceImplementation;

import com.santharam.get_fit.GlobalExceptionHandler.ResourceNotFoundException;
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
            Gym gym = gymRepo.findById(request.getGymId()).orElseThrow(() ->  new ResourceNotFoundException("Gym not found  "+request.getGymId()));
            Equipment equipment=equipmentRepo.findById(request.getEquipmentId()).orElseThrow(()->new ResourceNotFoundException("Equipment not found "+request.getEquipmentId()));
            GymEquipment gymEquipment=gymEquipmentTransformService.toEntity(request,gym,equipment);
            return gymEquipmentRepo.save(gymEquipment);
        }
    }

    @Override
    public List<GymEquipment> getEquipmentByGym(Long gymId) {
        List<GymEquipment> gymEquipmentList = gymEquipmentRepo.findByGymId(gymId);
        if (gymEquipmentList.isEmpty()) {
            throw new ResourceNotFoundException("No equipment found for gym " + gymId);
        }
        return gymEquipmentList;
    }

    @Override
    public GymEquipment updateQuantity(Long gymEquipmentId,Integer quantity) {
        GymEquipment gymEquipment=gymEquipmentRepo.findById(gymEquipmentId).orElseThrow(()->new ResourceNotFoundException("Gym Equipment Not Found"));
        gymEquipment.setQuantity(quantity);
        return gymEquipmentRepo.save(gymEquipment);
    }

    @Override
    public GymEquipment updateAvailability(Long gymEquipmentId, Boolean available) {
        GymEquipment gymEquipment =
                gymEquipmentRepo.findById(
                        gymEquipmentId
                ).orElseThrow(() ->
                        new ResourceNotFoundException(
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
