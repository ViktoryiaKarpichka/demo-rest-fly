package com.example.demorestfly.services;

import com.example.demorestfly.dto.UserDto;

import java.util.List;

public interface AdminService {
    void setAdmin(Long id);

    List<UserDto> getAllUsers();
}
