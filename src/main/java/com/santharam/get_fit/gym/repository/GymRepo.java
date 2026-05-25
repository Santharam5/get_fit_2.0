package com.santharam.get_fit.gym.repository;

import com.santharam.get_fit.gym.entity.Gym;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GymRepo extends JpaRepository<Gym,Long> {

}
