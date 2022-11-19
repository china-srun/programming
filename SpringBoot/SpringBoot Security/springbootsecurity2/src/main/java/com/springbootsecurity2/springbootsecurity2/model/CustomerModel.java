package com.springbootsecurity2.springbootsecurity2.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="tbl_customer")
public class CustomerModel {
    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "name")
    private String name;

    public CustomerModel() {}

    public CustomerModel(String id, String name) {
        this.id = id;
        this.name = name;
    }

    
}
