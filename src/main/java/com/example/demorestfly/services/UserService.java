package com.example.demorestfly.services;

import com.example.demorestfly.dto.UserDto;
import com.example.demorestfly.dto.UserRegistrationDto;
import com.example.demorestfly.entities.User;

import java.util.List;

public interface UserService {

    User getUserByUsername(String username);

    void saveUser(UserRegistrationDto user);

    boolean isUserExist(String userName);

    void setRoleAdmin(Long id);

    List<UserDto> getAllUsers();
}
