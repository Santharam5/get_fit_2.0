package com.santharam.get_fit.users.entity;

import com.santharam.get_fit.membership.entity.Membership;
import com.santharam.get_fit.users.enums.Roles;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name="users")
public class Users {
@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(unique = true)
    private String email;
    private String password;
    private Roles roles;
    private String phoneNumber;
    @OneToMany(mappedBy = "users")
    @JoinColumn(name="ID_MEMBERSHIP")
    private List<Membership> membership;

}
