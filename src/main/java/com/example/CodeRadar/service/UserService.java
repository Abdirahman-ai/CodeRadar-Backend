package com.example.CodeRadar.service;

import com.example.CodeRadar.dto.LoginRequestDto;
import com.example.CodeRadar.dto.LoginResponseDto;
import com.example.CodeRadar.dto.UserDto;

import java.util.List;

public interface UserService {
    UserDto createUser(UserDto userDto);
    List<UserDto> getAllUsers();
    UserDto getUserById(Long id);
    // service/UserService.java
    LoginResponseDto loginUser(LoginRequestDto loginRequestDto);

}
