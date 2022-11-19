package com.tgisecurity.tgitest.repository;
import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;

import com.tgisecurity.tgitest.model.RolePrivilege;

public interface RolePrivilegeRepository extends JpaRepository<RolePrivilege, String> {
    List<RolePrivilege> findAllByRoleId(String roleId);
}
