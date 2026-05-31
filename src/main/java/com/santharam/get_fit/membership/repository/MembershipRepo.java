package com.santharam.get_fit.membership.repository;

import com.santharam.get_fit.membership.entity.Membership;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MembershipRepo extends JpaRepository<Membership,Long> {

    List<Membership> findByUserId(Long userId);
    List<Membership> findByGymId(Long gymId);
}
