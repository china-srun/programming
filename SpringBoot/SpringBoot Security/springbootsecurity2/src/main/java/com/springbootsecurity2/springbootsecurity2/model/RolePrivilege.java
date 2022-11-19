package com.springbootsecurity2.springbootsecurity2.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Setter;

import lombok.Getter;

@Entity
@Table(name = "tbl_role_privilege")
@Getter
@Setter
public class RolePrivilege {
    @Id
    @Column(name = "id", nullable = false)
    private String id;

    @Column(name = "role_id", nullable = false)
    private String roleId;

    @Column(name = "privilege_id", nullable = false)
    private String privilegeId;

    public RolePrivilege() {}

    public RolePrivilege(String id, String roleId, String privilegeId) {
        this.id = id;
        this.roleId = roleId;
        this.privilegeId = privilegeId;
    }

}
