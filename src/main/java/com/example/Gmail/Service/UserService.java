package com.example.Gmail.Service;

import com.example.Gmail.DTO.LoginRequest;
import com.example.Gmail.DTO.UserRequest;
import com.example.Gmail.DTO.UserResponse;
import com.example.Gmail.Entity.User;
import com.example.Gmail.Repo.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    public final UserRepository repo;
    public final PasswordEncoder passwordEncoder;

    public UserResponse saveUser(UserRequest request){
        if(repo.findByEmail(request.getEmail()).isPresent()){
            throw  new RuntimeException("User Already exists with this email");
        }
        User user = new User();
        user.setUsername(request.getUsername());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setEmail(request.getEmail());

        User savedUser = repo.save(user);
        UserResponse response = new UserResponse();
        response.setMessage("User registered successfully");
        response.setUsername(savedUser.getUsername());
        response.setEmail(savedUser.getEmail());
        return  response;
    }

    public User login(LoginRequest request) {

        Optional<Object> optionalUser = repo.findByEmail(request.getEmail());

        if (optionalUser.isEmpty()) {
            throw new RuntimeException("USER_NOT_FOUND");
        }

        User user = (User) optionalUser.get();

        boolean match = passwordEncoder.matches(
                request.getPassword(),
                user.getPassword()
        );

        if (!match) {
            throw new RuntimeException("INVALID_PASSWORD");
        }

        return user;
    }

}
