package com.example.securityProject.controller;

import com.example.securityProject.dto.UserDto;

import com.example.securityProject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {
    @Autowired
    private UserService userService;

    // Login Page
    @GetMapping("/login")
    public String login() {
        return "login";
    }

    // Show Registration page
    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new UserDto());
        return "register";
    }

    // Register a New User
    @PostMapping("/register")
    public String registerUser(@ModelAttribute("user") UserDto userDto, Model model) {
        if (userService.findByUsername(userDto.getUsername()) != null) {
            model.addAttribute("error", "Username already exists");
            return "register";
        }
        userService.save(userDto);
        return "redirect:/login?success";
    }
}
