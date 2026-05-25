package com.santharam.get_fit.gym.service;

import com.santharam.get_fit.gym.dto.GymRequestDto;
import com.santharam.get_fit.gym.entity.Gym;

import java.util.List;

public interface GymService {
    public Gym createGym(GymRequestDto gymRequestDto);
    public List<Gym> getAllGyms();
    public Gym getGym(Long id);
}
