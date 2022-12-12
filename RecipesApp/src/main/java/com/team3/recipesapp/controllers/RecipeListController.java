package com.team3.recipesapp.controllers;

import com.team3.recipesapp.RecipeList;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class RecipeListController {
    @GetMapping("/recipelist")
    public List<RecipeList> getAllRecipes() {
        return Arrays.asList(
                new RecipeList("1a", "chicken with fries", "dinner"),
                new RecipeList("2a", "greek salads", "vegetarian")
        );
    }
}
