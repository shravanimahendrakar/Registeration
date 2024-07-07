package com.example.registeration.controller;

import com.example.registeration.model.*;
import com.example.registeration.repository.*;
import com.example.registeration.service.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/signin")
    public String showSignInForm(Model model) {
        model.addAttribute("user", new User());
        return "signin";
    }
    
    @PostMapping("/signin")
    public String signInUser(User user, Model model) {
        User existingUser = userService.findByUsername(user.getUsername());
        if (existingUser != null && existingUser.getPassword().equals(user.getPassword())) {
            model.addAttribute("welcomeMessage", "Welcome, " + user.getUsername() + "!");
            return "welcome";
        } else {
            model.addAttribute("errorMessage", "Invalid username or password!");
            return "signin";
        }
    }
    
    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute("user") User user, Model model) {
        User existingUser = userService.findByUsername(user.getUsername());
        if (existingUser != null) {
            model.addAttribute("message", "Username already exists");
            return "register";
        }
        userService.saveUser(user);
        model.addAttribute("message", "User registered successfully");
        return "redirect:/register";
    }  
}
