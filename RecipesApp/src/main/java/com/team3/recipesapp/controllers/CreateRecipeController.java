package com.team3.recipesapp.controllers;

import com.team3.recipesapp.Recipe;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class CreateRecipeController {
    @RequestMapping("/createrecipe")
    public List<Recipe> createRecipe() {
        return Arrays.asList(
                new Recipe("breakfast", "pork chops", "make chops"));
    }
}
