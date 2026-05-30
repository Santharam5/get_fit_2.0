package com.santharam.get_fit.users.transform;

import com.santharam.get_fit.users.dto.UsersRequestDto;
import com.santharam.get_fit.users.entity.Users;
import lombok.Builder;
import lombok.Data;
import org.springframework.stereotype.Service;
@Service
@Data
@Builder
public class UsersTransformService {
    public Users toEntity(UsersRequestDto usersRequestDto){
        return Users.builder()
                .name(usersRequestDto.getName())
                .email(usersRequestDto.getEmail())
                .password(usersRequestDto.getPassword())
                .roles(usersRequestDto.getRoles())
                .phoneNumber(usersRequestDto.getPhoneNumber())
                .build();
    }
}
