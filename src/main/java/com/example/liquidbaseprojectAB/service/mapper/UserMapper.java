package com.example.liquidbaseprojectAB.service.mapper;

import com.example.liquidbaseprojectAB.entity.User;
import com.example.liquidbaseprojectAB.entity.dto.UserDto;

public class UserMapper {

    public static UserDto toDto(User user){
        UserDto userDto = new UserDto();
        userDto.setId(user.getIdUser());
        userDto.setName(user.getName());
        userDto.setEmail(user.getEmail());
        userDto.setGender(user.getGender());
        userDto.setStatus(user.getStatus());
        return userDto;
    }

    public static User toEntity(UserDto userDto){
        User user = new User();
        user.setIdUser(userDto.getId());
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setGender(userDto.getGender());
        user.setStatus(userDto.getStatus());
        return user;
    }
}
