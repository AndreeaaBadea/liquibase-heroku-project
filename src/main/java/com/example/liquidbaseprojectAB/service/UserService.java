package com.example.liquidbaseprojectAB.service;

import com.example.liquidbaseprojectAB.entity.User;
import com.example.liquidbaseprojectAB.entity.dto.UserDto;
import com.example.liquidbaseprojectAB.exception.AccessDatabaseException;
import com.example.liquidbaseprojectAB.exception.NoSuchUserException;
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

    public UserDto addUser(UserDto userDto) {
        User user = userRepository.save(UserMapper.toEntity(userDto));
        Logger.info("Added user id {}.", userDto.getId());
        return UserMapper.toDto(user);
    }

    public List<UserDto> getAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(UserMapper::toDto)
                .collect(Collectors.toList());
    }

    public UserDto getUserById(int id) {
        User user = userRepository.getById(id);
        if (user == null) {
            Logger.info("There is no user with given id.");
            throw new NoSuchUserException("There is no user with given id.");
        }
        return UserMapper.toDto(user);
    }

    public void deleteUserById(int id) {
        userRepository.getById(id);
        Logger.info("Customer id {} deleted from database. ", id);
    }
}




