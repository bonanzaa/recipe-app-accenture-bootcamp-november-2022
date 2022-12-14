package com.team3.recipesapp.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
//@RequestMapping("/feed")
public class FeedController {

        @GetMapping("/feed")
        String getHome(Model model) {
            model.addAttribute("message1", "What's on your mind");
            return "feed";
        }
    }
