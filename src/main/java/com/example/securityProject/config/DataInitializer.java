package com.example.securityProject.config;

import com.example.securityProject.model.Role;
import com.example.securityProject.model.User;

import com.example.securityProject.repository.RoleRepository;
import com.example.securityProject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class DataInitializer implements CommandLineRunner {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        // Create default roles
        Role userRole = roleRepository.findByName("ROLE_USER");
        if (userRole == null) {
            userRole = new Role("ROLE_USER", "Default user role");
            roleRepository.save(userRole);
        }

        Role adminRole = roleRepository.findByName("ROLE_ADMIN");
        if (adminRole == null) {
            adminRole = new Role("ROLE_ADMIN", "Administrator role");
            roleRepository.save(adminRole);
        }

        // Create default admin user
        if (userRepository.findByUsername("admin") == null) {
            User admin = new User(
                    "admin",
                    passwordEncoder.encode("admin123"),
                    "Admin User",
                    "admin@example.com"
            );
            Set<Role> roles = new HashSet<>();
            roles.add(adminRole);
            admin.setRoles(roles);
            userRepository.save(admin);
        }
    }
}
