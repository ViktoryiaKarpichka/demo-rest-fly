package com.example.demorestfly.services.impl;

import com.example.demorestfly.dto.UserDto;
import com.example.demorestfly.services.AdminService;
import com.example.demorestfly.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService {

    private final UserService userService;

    @Override
    public void setAdmin(Long id) {
        userService.setRoleAdmin(id);
    }

    @Override
    public List<UserDto> getAllUsers() {
        return userService.getAllUsers();
    }
}
