package com.team3.recipesapp.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class HomeController {
    @RequestMapping("/home")
    public String welcome(){
        return "Welcome to your favorite recipe page";
    }
}


