package com.secondproject.secondspringboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.secondproject.secondspringboot.model.user;

public interface userRepository extends JpaRepository<user, String>{
    List<user> findAllByStatus(String status);
}
