package com.example.Gmail.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserResponse {
    private String message ="User is registered";
    private String username;
    private  String email;
}
