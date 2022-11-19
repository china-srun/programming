package com.tgisecurity.tgitest.model;

import javax.persistence.*;


@Entity
@Table(name = "tbl_role")
public class Role {

    @Id
    @Column(name = "id", nullable = false)
    private String id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description")
    private String desc;

    public Role() {
    }

    public Role(String id, String name, String description) {
        this.id = id;
        this.name = name;
        this.desc = description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }


    
}
