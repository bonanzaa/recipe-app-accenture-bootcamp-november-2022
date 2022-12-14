package com.team3.recipesapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class WelcomeController {
    @GetMapping("/tempelate1")
     String getHome(Model model) {
        model.addAttribute("message", "Welcome to the app!");
        return "index";
    }
}

