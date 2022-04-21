package com.example.liquidbaseprojectAB.service;

import com.example.liquidbaseprojectAB.entity.User;
import com.example.liquidbaseprojectAB.entity.dto.UserDto;
import com.example.liquidbaseprojectAB.repository.UserRepository;
import com.example.liquidbaseprojectAB.service.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tinylog.Logger;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public UserDto addUser(UserDto userDto){
        User user = userRepository.save(UserMapper.toEntity(userDto));
        Logger.info("Added user id {}.", userDto.getId());
        return UserMapper.toDto(user);
    }

    public List<UserDto> getAllUsers(){
        return userRepository.findAll()
                .stream()
                .map(UserMapper::toDto)
                .collect(Collectors.toList());
    }

    public UserDto getUserById(int id){
        return UserMapper.toDto(userRepository.getById(id));
    }

}
