package com.springbootsecurity2.springbootsecurity2.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springbootsecurity2.springbootsecurity2.model.RolePrivilege;

public interface RolePrivilegeRepository extends JpaRepository<RolePrivilege, String> {
    // the same as, select * from RolePrivilege where roleId == {inputID}
    List<RolePrivilege> findAllByRoleId(String roleId);
}
