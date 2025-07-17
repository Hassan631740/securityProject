package com.example.securityProject.service;

import com.example.securityProject.dto.UserDto;
import com.example.securityProject.model.User;

public interface UserService {
    User save(UserDto userDto);
    User findByUsername(String username);
}
