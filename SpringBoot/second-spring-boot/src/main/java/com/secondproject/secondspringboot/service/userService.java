package com.secondproject.secondspringboot.service;

import java.util.List;

import com.secondproject.secondspringboot.dataTransferObject.userDto;
import com.secondproject.secondspringboot.model.user;

public interface userService {
    List<user> getUsers();

    user getByUserId(String id);

    user createUser(userDto UserDto);

    user updateUser(String id, userDto newUserInfo);

    user deleteUser(String id);
}
