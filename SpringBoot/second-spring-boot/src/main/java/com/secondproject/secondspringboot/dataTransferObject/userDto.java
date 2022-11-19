package com.secondproject.secondspringboot.dataTransferObject;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class userDto {
    private String firstname;
    private String lastname;
    private String gender;
    private String password;

    public userDto() {}

    public userDto(String firstname, String lastname, String gender, String password) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.gender = gender;
        this.password = password;
    }
 
    
}
