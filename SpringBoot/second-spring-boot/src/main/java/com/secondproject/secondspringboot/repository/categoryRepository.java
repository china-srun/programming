package com.secondproject.secondspringboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.secondproject.secondspringboot.model.category;

public interface categoryRepository extends JpaRepository<category, String> {
    
}
