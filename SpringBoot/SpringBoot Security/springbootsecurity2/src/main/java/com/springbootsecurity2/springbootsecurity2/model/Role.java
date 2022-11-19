package com.springbootsecurity2.springbootsecurity2.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "tbl_role")
@Getter
@Setter
public class Role {
    @Id 
    @Column(name = "id", nullable = false)
    private String id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description")
    private String desc;

    public Role() {}

    public Role(String id, String name, String desc) {
        this.id = id;
        this.name = name;
        this.desc = desc;
    }

    
}
