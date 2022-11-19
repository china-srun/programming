package com.tgisecurity.tgitest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tgisecurity.tgitest.model.Privilege;

public interface PrivilegeRepository extends JpaRepository<Privilege, String> {

}
