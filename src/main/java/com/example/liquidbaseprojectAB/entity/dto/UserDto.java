package com.example.liquidbaseprojectAB.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    private Integer id;

    private String name;

    private String email;

    private String gender;

    private String status;



}
