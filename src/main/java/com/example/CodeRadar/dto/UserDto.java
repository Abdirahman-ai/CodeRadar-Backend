package com.example.CodeRadar.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private Long id;
    private String githubUsername;
    private String fullName;
    private String email;
    private String password;
}
