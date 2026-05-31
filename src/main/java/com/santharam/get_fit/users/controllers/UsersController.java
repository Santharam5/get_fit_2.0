package com.santharam.get_fit.users.controllers;

import com.santharam.get_fit.users.dto.UsersRequestDto;
import com.santharam.get_fit.users.entity.Users;
import com.santharam.get_fit.users.service.UsersService;
import lombok.Builder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Builder
@RequestMapping("/api/user")
public class UsersController {
    @Autowired
    UsersService usersService;
    @PostMapping("/register")
    public ResponseEntity<Users> createUser(@RequestBody UsersRequestDto request){
        Users users= usersService.createUser(request);
        return ResponseEntity.status(201).body(users);
    }
    @GetMapping("/all")
    public ResponseEntity<List<Users>> getAllUsers(){
        List<Users> users= usersService.getAllUSers();
        return ResponseEntity.status(200).body(users);
    }
    @GetMapping("/{userId}")
    public ResponseEntity<Users> getUserById(@RequestParam Long userId){
        Users users= usersService.getUserById(userId);
        return ResponseEntity.status(200).body(users);
    }


}
