package com.santharam.get_fit.membership.transform;

import com.santharam.get_fit.gym.entity.Gym;
import com.santharam.get_fit.membership.dto.MembershipRequestDto;
import com.santharam.get_fit.membership.entity.Membership;
import com.santharam.get_fit.users.entity.Users;
import lombok.Builder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@Builder
public class MembershipTransformService {
    public Membership toEntity(MembershipRequestDto request, Users users, Gym gym){
        return Membership.builder()
                .users(users)
                .gym(gym)
                .planType(request.getPlanType())
                .startDate(LocalDate.now())
                .expiryDate(LocalDate.now().plusMonths(3))
                .paymentStatus(request.getPaymentStatus())
                .build();
    }
}
