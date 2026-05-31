package com.santharam.get_fit.membership.entity;

import com.santharam.get_fit.gym.entity.Gym;
import com.santharam.get_fit.users.entity.Users;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "MEMBERSHIP")
public class Membership {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users users;
    @ManyToOne
    @JoinColumn(name = "gym_id")
    private Gym gym;
    private String planType;
    private LocalDate startDate;
    private LocalDate expiryDate;
    private String paymentStatus;
}
