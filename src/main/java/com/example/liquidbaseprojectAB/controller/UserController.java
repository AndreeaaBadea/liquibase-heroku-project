package com.example.liquidbaseprojectAB.controller;

import com.example.liquidbaseprojectAB.entity.dto.UserDto;
import com.example.liquidbaseprojectAB.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping()
    public ResponseEntity<UserDto> addPerson(@RequestBody UserDto userDto){
        return new ResponseEntity<UserDto>(userService.addUser(userDto), HttpStatus.CREATED);
    }

    @GetMapping()
    public  ResponseEntity<List<UserDto>> getAllPersons(){
        return new ResponseEntity<List<UserDto>>(userService.getAllUsers(), HttpStatus.OK);
    }

    @GetMapping("/id")
    public ResponseEntity<UserDto> getUserById(@RequestParam int id){
        return new ResponseEntity<>(userService.getUserById(id), HttpStatus.OK);
    }

    @DeleteMapping()
    public ResponseEntity<String> deleteUser(@RequestParam int id){
        return new ResponseEntity<>("Delete person id " + id, HttpStatus.OK);
    }

}
