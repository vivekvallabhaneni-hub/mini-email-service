package com.example.Gmail.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginRequest {
    private String Username;
    private String password;
    private String email;
}
