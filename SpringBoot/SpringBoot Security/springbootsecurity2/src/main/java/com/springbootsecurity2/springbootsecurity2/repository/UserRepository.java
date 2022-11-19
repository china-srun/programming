package com.springbootsecurity2.springbootsecurity2.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springbootsecurity2.springbootsecurity2.model.User;

public interface UserRepository extends JpaRepository<User, String>{
    Optional<User> findByUserName(String userName);
}
