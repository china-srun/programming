package com.tgisecurity.tgitest.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tgisecurity.tgitest.model.User;

public interface UserRepository extends JpaRepository<User, String> {
    Optional<User> findByUserName(String userName);
}
