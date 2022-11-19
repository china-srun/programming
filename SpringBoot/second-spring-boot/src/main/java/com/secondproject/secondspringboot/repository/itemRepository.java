package com.secondproject.secondspringboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.secondproject.secondspringboot.model.item;

public interface itemRepository extends JpaRepository<item, String>{
    List<item> findItemsByStatus(String status);
}
