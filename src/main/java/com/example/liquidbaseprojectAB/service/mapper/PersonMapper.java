package com.example.liquidbaseprojectAB.service.mapper;

import com.example.liquidbaseprojectAB.entity.Person;
import com.example.liquidbaseprojectAB.entity.dto.PersonDto;

public class PersonMapper {

    public static PersonDto toDto(Person person){
        PersonDto personDto = new PersonDto();
        personDto.setId(person.getId());
        personDto.setFirstName(person.getFirstName());
        personDto.setLastName(person.getLastName());
        return personDto;
    }

    public static Person toEntity(PersonDto personDto){
        Person person = new Person();
        person.setId(personDto.getId());
        person.setFirstName(personDto.getFirstName());
        person.setLastName(personDto.getLastName());
        return person;
    }
}
