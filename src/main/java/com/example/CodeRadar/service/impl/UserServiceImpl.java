package com.example.CodeRadar.service.impl;

import com.example.CodeRadar.dto.UserDto;
import com.example.CodeRadar.entity.User;
import com.example.CodeRadar.exception.ResourceNotFoundException;
import com.example.CodeRadar.mapper.UserMapper;
import com.example.CodeRadar.repository.UserRepository;
import com.example.CodeRadar.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public UserDto createUser(UserDto userDto) {
        User user = userMapper.dtoToEntity(userDto);
        return userMapper.entityToDto(userRepository.saveAndFlush(user));
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> allUsers = userRepository.findAll();
        return userMapper.entitiesToDto(allUsers);
    }

    @Override
    public UserDto getUserById(Long id) {
        Optional<User> user = userRepository.findById(id);
        if(user.isEmpty()){
            throw new ResourceNotFoundException("User not found with id: " + id);
        }
        return userMapper.entityToDto(user.get());
    }
}
