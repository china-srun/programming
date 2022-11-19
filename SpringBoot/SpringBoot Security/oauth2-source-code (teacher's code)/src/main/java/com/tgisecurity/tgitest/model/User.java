package com.tgisecurity.tgitest.model;

import javax.persistence.*;
import java.util.Set;

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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Boolean getIsLocked() {
        return isLocked;
    }

    public void setIsLocked(Boolean isLocked) {
        this.isLocked = isLocked;
    }

    public Integer getNumberOfLock() {
        return numberOfLock;
    }

    public void setNumberOfLock(Integer numberOfLock) {
        this.numberOfLock = numberOfLock;
    }

    public Boolean getFirstLogin() {
        return firstLogin;
    }

    public void setFirstLogin(Boolean firstLogin) {
        this.firstLogin = firstLogin;
    }

    
}
