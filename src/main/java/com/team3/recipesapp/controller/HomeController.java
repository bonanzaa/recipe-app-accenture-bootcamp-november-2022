package com.team3.recipesapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
//@RequestMapping("/feed")
public class HomeController {

        @GetMapping("/home")
        String getHome(Model model) {
            model.addAttribute("message1", "What's on your mind");
            return "home";
        }
    }