package com.secondproject.secondspringboot.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "tbl_user")
@Getter
@Setter
public class user {

    // we use @column annotation to tell the database which data put in which column

    // @Id annotation tells that we want our id to be the primary key
    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "first_name")
    private String firstname;

    @Column(name = "last_name")
    private String lastname;

    @Column(name = "gender")
    private String gender;

    @Column(name = "password")
    private String password;

    @Column(name = "createdDate")
    private Date createdDate;

    @Column(name = "status")
    private String status;

    public user() {}

    public user(String id, String firstname, String lastname, String gender, String password, Date createdDate, String status) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.gender = gender;
        this.password = password;
        this.createdDate = createdDate;
        this.status = status;
    }
    
}
