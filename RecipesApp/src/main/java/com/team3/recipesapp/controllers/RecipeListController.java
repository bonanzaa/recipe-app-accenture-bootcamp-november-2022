package com.team3.recipesapp.controllers;

import com.team3.recipesapp.RecipeList;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class RecipeListController {
    @RequestMapping("/recipelist")
    public List<RecipeList> getAllRecipes() {
        return Arrays.asList(
                new RecipeList("1a", "chicken with fries", "dinner"),
                new RecipeList("2a", "greek salads", "vegetarian")
        );
    }
}
