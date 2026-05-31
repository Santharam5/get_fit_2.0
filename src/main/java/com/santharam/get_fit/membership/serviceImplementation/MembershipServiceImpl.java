package com.santharam.get_fit.membership.serviceImplementation;

import com.santharam.get_fit.gym.entity.Gym;
import com.santharam.get_fit.gym.repository.GymRepo;
import com.santharam.get_fit.membership.dto.MembershipRequestDto;
import com.santharam.get_fit.membership.entity.Membership;
import com.santharam.get_fit.membership.repository.MembershipRepo;
import com.santharam.get_fit.membership.service.MembershipService;
import com.santharam.get_fit.membership.transform.MembershipTransformService;
import com.santharam.get_fit.users.entity.Users;
import com.santharam.get_fit.users.repository.UsersRepo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MembershipServiceImpl implements MembershipService {
    @Autowired
    MembershipRepo membershipRepo;
    @Autowired
    GymRepo gymRepo;
    @Autowired
    UsersRepo  usersRepo;
    @Autowired
    MembershipTransformService membershipTransformService;
    @Override
    public Membership createMembership(MembershipRequestDto request) {
        Users users=usersRepo.findById(request.getUserId()).orElseThrow(()->new RuntimeException("User not found"));
        Gym gym=gymRepo.findById(request.getGymId()).orElseThrow(()->new RuntimeException("Gym not found"));
        Membership membership=membershipTransformService.toEntity(request,users,gym);
        return membershipRepo.save(membership);
    }

    @Override
    public List<Membership> getMembershipByUser(Long userId) {

        return membershipRepo.findByUserId(userId);
    }

    @Override
    public List<Membership> getMembershipByGym(Long gymId) {

        return membershipRepo.findByGymId(gymId);
    }
}
