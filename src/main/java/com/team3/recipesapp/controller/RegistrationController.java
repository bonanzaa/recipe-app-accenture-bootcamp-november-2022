package com.team3.recipesapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class RegistrationController {

    @GetMapping("registration")
    private String getRegisterView() {
        return "registration";
    }
}