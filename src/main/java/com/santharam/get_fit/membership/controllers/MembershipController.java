package com.santharam.get_fit.membership.controllers;

import com.santharam.get_fit.membership.dto.MembershipRequestDto;
import com.santharam.get_fit.membership.entity.Membership;
import com.santharam.get_fit.membership.service.MembershipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/membership")
public class MembershipController {
    @Autowired
    MembershipService membershipService;
    @PostMapping("/create")
    public ResponseEntity<Membership> createMembership(@RequestBody MembershipRequestDto request){
        Membership membership=membershipService.createMembership(request);
        return ResponseEntity.status(201).body(membership);
    }
    @GetMapping("/getmembershipbyuser")
    public ResponseEntity<List<Membership>> getMembershipByUser(@RequestParam Long userId){
        List<Membership> membership=membershipService.getMembershipByUser(userId);
        return ResponseEntity.status(200).body(membership);
    }
    @GetMapping("/getmembershipbygym")
    public ResponseEntity<List<Membership>> getMembershipByGym(@RequestParam Long gymId){
        List<Membership> membership=membershipService.getMembershipByGym(gymId);
        return ResponseEntity.status(200).body(membership);
    }
}
