package com.santharam.get_fit.users.dto;

import com.santharam.get_fit.users.enums.Roles;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UsersRequestDto {
    private String name;
    private String email;
    private String password;
    private Roles roles;
    private String phoneNumber;
}
