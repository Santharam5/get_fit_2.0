package com.santharam.get_fit.membership.service;

import com.santharam.get_fit.membership.dto.MembershipRequestDto;
import com.santharam.get_fit.membership.entity.Membership;

import java.util.List;

public interface MembershipService {

    Membership createMembership(MembershipRequestDto request);
    List<Membership> getMembershipByUser(Long userId);
    List<Membership> getMembershipByGym(Long gymId);

}
