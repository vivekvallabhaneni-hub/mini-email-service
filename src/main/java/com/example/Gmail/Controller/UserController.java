package com.example.Gmail.Controller;

import com.example.Gmail.DTO.LoginRequest;
import com.example.Gmail.DTO.UserRequest;
import com.example.Gmail.DTO.UserResponse;
import com.example.Gmail.Entity.User;
import com.example.Gmail.Repo.UserRepository;
import com.example.Gmail.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {
    public final UserService service;

    @PostMapping("/save")
    public UserResponse saveUser(@RequestBody UserRequest req){
        return service.saveUser(req);
    }
    @PostMapping("/login")
    public String loginRequest(@RequestBody LoginRequest req){
        service.login(req);
        return "Login Successful";
    }

}
