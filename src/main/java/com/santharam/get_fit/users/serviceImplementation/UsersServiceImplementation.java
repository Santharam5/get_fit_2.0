package com.santharam.get_fit.users.serviceImplementation;

import com.santharam.get_fit.GlobalExceptionHandler.EntityMappedException;
import com.santharam.get_fit.GlobalExceptionHandler.HandleEntityAlreadyExistsException;
import com.santharam.get_fit.GlobalExceptionHandler.ResourceNotFoundException;
import com.santharam.get_fit.membership.repository.MembershipRepo;
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
    @Autowired
    MembershipRepo membershipRepo;
    @Override
    public Users createUser(UsersRequestDto usersRequestDto) {
        boolean exists=usersRepo.existsByEmail(usersRequestDto.getEmail());
        if(exists){
            throw new EntityMappedException("Email already exists " + usersRequestDto.getEmail());
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
        return usersRepo.findById(userId).orElseThrow(()->new ResourceNotFoundException("User not found " + userId));
    }

    @Override
    public Users updateUser(Long userId, UsersRequestDto usersRequestDto) {
        Users existingUser = usersRepo.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found " + userId));

        existingUser.setName(usersRequestDto.getName());
        existingUser.setEmail(usersRequestDto.getEmail());
        existingUser.setPassword(usersRequestDto.getPassword());
        existingUser.setRoles(usersRequestDto.getRoles());
        existingUser.setPhoneNumber(usersRequestDto.getPhoneNumber());

        return usersRepo.save(existingUser);
    }

    @Override
    public void deleteUser(Long userId) {
        Users existingUser = usersRepo.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found " + userId));

        var memberships = membershipRepo.findByUsersId(userId);
        if (memberships != null && !memberships.isEmpty()) {
            throw new HandleEntityAlreadyExistsException("Cannot delete user with existing memberships " + userId);
        }

        usersRepo.delete(existingUser);
    }
}
