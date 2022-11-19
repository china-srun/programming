package com.tgisecurity.tgitest.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "tbl_customer")
@Entity
public class CustomerModel {
    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "name")
    private String name;
}
