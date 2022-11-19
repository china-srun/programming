package com.springbootsecurity2.springbootsecurity2.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tbl_user_role")
@Getter
@Setter
public class UserRole {
    @Id
    @Column(name = "id", nullable = false)
    private String id;

    @Column(name = "user_id", nullable = false)
    private String userId;

    @Column(name = "role_id", nullable = false)
    private String roleId;

    @Column(name = "reports_to")
    private String reportsTo;

    public UserRole() {}

    public UserRole(String id, String userId, String roleId, String reportsTo) {
        this.id = id;
        this.userId = userId;
        this.roleId = roleId;
        this.reportsTo = reportsTo;
    }

    
}
