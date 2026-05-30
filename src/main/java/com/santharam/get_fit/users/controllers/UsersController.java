package com.santharam.get_fit.users.controllers;

import com.santharam.get_fit.users.dto.UsersRequestDto;
import com.santharam.get_fit.users.entity.Users;
import com.santharam.get_fit.users.service.UsersService;
import lombok.Builder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Builder
@RequestMapping("/api/user")
public class UsersController {
    @Autowired
    UsersService usersService;
    @PostMapping("/register")
    public Users createUser(@RequestBody UsersRequestDto request){
        return usersService.createUser(request);
    }
    @GetMapping("/all")
    public List<Users> getAllUsers(){
        return usersService.getAllUSers();
    }
    @GetMapping("/{userId}")
    public Users getUserById(@RequestParam Long userId){
        return usersService.getUserById(userId);
    }


}
