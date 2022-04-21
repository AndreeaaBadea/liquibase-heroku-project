package com.example.liquidbaseprojectAB.repository;

import com.example.liquidbaseprojectAB.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}
