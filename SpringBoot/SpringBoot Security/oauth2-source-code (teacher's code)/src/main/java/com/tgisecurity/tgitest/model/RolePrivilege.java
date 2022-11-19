package com.tgisecurity.tgitest.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_role_privilege")
public class RolePrivilege {

    @Id
    @Column(name = "id", nullable = false)
    private String id;

    @Column(name = "role_id", nullable = false)
    private String roleId;

    @Column(name = "privilege_id", nullable = false)
    private String privilegeId;

    public RolePrivilege() {
    }

    public RolePrivilege(String roleId, String privilegeId) {
        this.roleId = roleId;
        this.privilegeId = privilegeId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getPrivilegeId() {
        return privilegeId;
    }

    public void setPrivilegeId(String privilegeId) {
        this.privilegeId = privilegeId;
    }

    
}
