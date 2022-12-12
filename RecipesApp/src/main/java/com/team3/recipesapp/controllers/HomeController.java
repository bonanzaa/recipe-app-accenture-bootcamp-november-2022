package com.team3.recipesapp.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class HomeController {
    @GetMapping("/home")
    public String welcome(){
        return "Welcome to your favorite recipe page";
    }
}


