package com.springbootsecurity2.springbootsecurity2.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
@Table(name = "tbl_user")
public class User {
    @Id
    @Column(name = "id", nullable = false)
    private String id;

    @Column(name = "full_name", nullable = false)
    private String fullName;

    @Column(name = "username", nullable = false, unique = true)
    private String userName;

    @Column(name = "gender", nullable = false)
    private String gender;

    @Column(name = "email")
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "phone", nullable = false)
    private String phone;

    @Column(name = "address")
    private String address;

    // INITIAL IN BACK END
    @Column(name = "is_locked", nullable = false)
    private Boolean isLocked;

    // INITIAL IN BACK END
    @Column(name = "number_of_lock", nullable = false)
    private Integer numberOfLock;

    // INITIAL IN BACK END
    @Column(name = "first_login", nullable = false)
    private Boolean firstLogin;


    public User() {
    }

    public User(String id, String fullName, String userName, String gender, String email, String password,
            String phone, String address, Boolean isLocked, Integer numberOfLock,
            Boolean firstLogin) {
        this.id = id;
        this.fullName = fullName;
        this.userName = userName;
        this.gender = gender;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.address = address;
        this.isLocked = isLocked;
        this.numberOfLock = numberOfLock;
        this.firstLogin = firstLogin;
    }

    
}
