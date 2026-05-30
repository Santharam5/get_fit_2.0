package com.santharam.get_fit.users.service;


import com.santharam.get_fit.users.dto.UsersRequestDto;
import com.santharam.get_fit.users.entity.Users;

import java.util.List;

public interface UsersService {
     Users createUser(UsersRequestDto usersRequestDto);
     List<Users> getAllUSers();
     Users getUserById(Long userId);

}
