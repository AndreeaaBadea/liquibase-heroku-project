package com.example.liquidbaseprojectAB.controller;

import com.example.liquidbaseprojectAB.entity.Person;
import com.example.liquidbaseprojectAB.entity.dto.PersonDto;
import com.example.liquidbaseprojectAB.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RequestMapping("/persons")
public class PersonController {

    @Autowired
    PersonService personService;

    @PostMapping
    public ResponseEntity<PersonDto> addPerson(@RequestBody PersonDto personDto){
        return new ResponseEntity<PersonDto>(personService.addPerson(personDto), HttpStatus.CREATED);
    }

    @GetMapping("/persons")
    public  ResponseEntity<List<PersonDto>> getAllPersons(){
        return new ResponseEntity<List<PersonDto>>(personService.getAllPersons(), HttpStatus.OK);
    }


}
