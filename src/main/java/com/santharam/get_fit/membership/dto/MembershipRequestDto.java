package com.santharam.get_fit.membership.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MembershipRequestDto {
    private Long userId;
    private Long gymId;
    private String planType;
    private String paymentStatus;
}
