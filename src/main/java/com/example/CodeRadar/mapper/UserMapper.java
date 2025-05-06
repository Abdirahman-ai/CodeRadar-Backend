package com.example.CodeRadar.mapper;

import com.example.CodeRadar.dto.UserDto;
import com.example.CodeRadar.entity.User;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDto entityToDto(User user);

    User dtoToEntity(UserDto userDto);

    List<UserDto> entitiesToDto(List<User> users);
}

