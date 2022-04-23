package com.example.liquidbaseprojectAB.controller;

import com.example.liquidbaseprojectAB.entity.dto.UserDto;
import com.example.liquidbaseprojectAB.exception.NoSuchUserException;
import com.example.liquidbaseprojectAB.exception.ResponseMessage;
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
    public ResponseEntity<UserDto> addUser(@RequestBody UserDto userDto){
        return new ResponseEntity<UserDto>(userService.addUser(userDto), HttpStatus.CREATED);
    }

    @GetMapping()
    public  ResponseEntity<List<UserDto>> getAllUsers(){
        return new ResponseEntity<List<UserDto>>(userService.getAllUsers(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUserById(@RequestParam int id){
        return new ResponseEntity<>(userService.getUserById(id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@RequestParam int id){
        userService.deleteUserById(id);
        return new ResponseEntity<String>("User deleted.", HttpStatus.OK);
    }


    @ExceptionHandler(NoSuchUserException.class)
    public ResponseEntity<ResponseMessage> handleNotFound(Exception exception){
        return new ResponseEntity<ResponseMessage>(new ResponseMessage("NO SUCH PROJECT"), HttpStatus.NOT_FOUND);
    }

}
