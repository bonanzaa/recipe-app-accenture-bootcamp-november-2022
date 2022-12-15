package com.team3.recipesapp.controller;


import com.team3.recipesapp.model.Recipe;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.team3.recipesapp.service.RecipeService;


@Controller
@RequiredArgsConstructor
//@RequestMapping("/feed")
public class HomeController {


    @Autowired
    private final RecipeService recipeService;

        @GetMapping("/home")
        String getHome(Model model) {
            model.addAttribute("message1", "What's on your mind");
            model.addAttribute("recipes",recipeService.getRecipes());
            return "home";
        }
    }