package com.example.liquidbaseprojectAB.service;

import com.example.liquidbaseprojectAB.entity.Person;
import com.example.liquidbaseprojectAB.entity.dto.PersonDto;
import com.example.liquidbaseprojectAB.repository.PersonRepository;
import com.example.liquidbaseprojectAB.service.mapper.PersonMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tinylog.Logger;

@Service
public class PersonService {

    @Autowired
    PersonRepository personRepository;

    public PersonDto addPerson(PersonDto personDto){
        Person person = personRepository.save(PersonMapper.toEntity(personDto));
        Logger.info("Added person id {}.", personDto.getId());
        return PersonMapper.toDto(person);

    }

}
