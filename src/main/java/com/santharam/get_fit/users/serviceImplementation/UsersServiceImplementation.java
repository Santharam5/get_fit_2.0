package com.santharam.get_fit.users.serviceImplementation;

import com.santharam.get_fit.users.dto.UsersRequestDto;
import com.santharam.get_fit.users.entity.Users;
import com.santharam.get_fit.users.repository.UsersRepo;
import com.santharam.get_fit.users.service.UsersService;
import com.santharam.get_fit.users.transform.UsersTransformService;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UsersServiceImplementation implements UsersService {
    @Autowired
    UsersRepo usersRepo;
    @Autowired
    UsersTransformService usersTransformService;
    @Override
    public Users createUser(UsersRequestDto usersRequestDto) {
        boolean exists=usersRepo.existsByEmail(usersRequestDto.getEmail());
        if(exists){
            throw new RuntimeException("Email already Exists");
        }
        else{
            Users users=usersTransformService.toEntity(usersRequestDto);
            return usersRepo.save(users);
        }
    }

    @Override
    public List<Users> getAllUSers() {
        return usersRepo.findAll();
    }

    @Override
    public Users getUserById(Long userId) {
        return usersRepo.findById(userId).orElseThrow(()->new RuntimeException("User not Found"));
    }
}
