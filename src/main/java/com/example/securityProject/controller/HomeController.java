package com.example.securityProject.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/home")
    public String home(Model model, Authentication authentication) {
        model.addAttribute("id", authentication.getName());
        model.addAttribute("name", authentication.getName());
        model.addAttribute("email", authentication.getName()); // Replace with actual email if stored
        return "home";
    }
}
