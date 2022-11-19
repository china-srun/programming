package com.secondproject.secondspringboot.service.implement;

import org.springframework.stereotype.Service;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import com.secondproject.secondspringboot.dataTransferObject.userDto;
import com.secondproject.secondspringboot.model.user;
import com.secondproject.secondspringboot.repository.userRepository;
import com.secondproject.secondspringboot.service.userService;


@Service
public class userServiceImpl implements userService{
    @Autowired
    private userRepository UserRepository;
    
    public List<user> getUsers() {
        Page<user> userPage = UserRepository.findAll(PageRequest.of(0, 25));
        // find only active user
        // List<user> userList = UserRepository.findAllByStatus("Active");
        return userPage.toList(); 
    }

    public user createUser(userDto UserDto) {
        user user = new user(UUID.randomUUID().toString(), UserDto.getFirstname(), UserDto.getLastname(),
         UserDto.getGender(), UserDto.getPassword(), new Date(), "Active");
        return UserRepository.save(user);
    }

    public user getByUserId(String id) {
        Optional<user> optionalUser = UserRepository.findById(id);

        if (optionalUser.isPresent()) {
            return optionalUser.get();
        }
        else {
            return null;
        }
    }

    public user updateUser(String id, userDto newUserInfo) {
        Optional<user> optionalUser = UserRepository.findById(id);
        user oldUserInfo = optionalUser.get();
        oldUserInfo.setFirstname(newUserInfo.getFirstname());
        oldUserInfo.setLastname(newUserInfo.getLastname());
        oldUserInfo.setGender(newUserInfo.getGender());
        oldUserInfo.setPassword(newUserInfo.getPassword());
        return UserRepository.save(oldUserInfo);
    }

    public user deleteUser(String id) {
        Optional<user> optionalUser = UserRepository.findById(id);
        user foundUser = optionalUser.get();

        // we dont want to permanemantly delete the user from the database, because it is high risk and it is impossible to roll back 
        // the best practice is to just change its status. This is why instead of delete function we update its stuatus
        foundUser.setStatus("Deleted");
        return UserRepository.save(foundUser);
    }

}
