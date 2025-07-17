package com.example.securityProject.controller;

import com.example.securityProject.model.Role;

import com.example.securityProject.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private RoleService roleService;

    @GetMapping("/add-role")
    public String showAddRoleForm(Model model) {
        model.addAttribute("role", new Role());
        return "add-role";
    }

    @PostMapping("/add-role")
    public String addRole(Role role, Model model) {
        if (roleService.findByName(role.getName()) != null) {
            model.addAttribute("error", "Role already exists");
            return "add-role";
        }
        roleService.save(role);
        return "redirect:/admin/add-role?success";
    }
}
