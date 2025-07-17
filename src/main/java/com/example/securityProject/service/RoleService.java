package com.example.securityProject.service;


import com.example.securityProject.model.Role;

public interface RoleService {
    Role save(Role role);
    Role findByName(String name);
}