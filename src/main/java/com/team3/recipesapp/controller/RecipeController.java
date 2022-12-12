package com.team3.recipesapp.controller;

import com.team3.recipesapp.model.Recipe;
import com.team3.recipesapp.model.User;
import com.team3.recipesapp.service.RecipeService;
import com.team3.recipesapp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class RecipeController {
    @Autowired
    private final RecipeService recipeService;

    @GetMapping("/recipes")
    public List<Recipe> recipes(){
        return recipeService.getRecipes();
    }

    @PostMapping("/recipe")
    public Recipe addRecipe(@RequestBody Recipe recipe){
        return recipeService.saveRecipe(recipe);
    }

    @PutMapping("/recipes/{id}")
    public Recipe replaceEmployee(@RequestBody Recipe newRecipe, @PathVariable String id) {

        return recipeService.replaceRecipe(newRecipe,id);
    }



    @DeleteMapping("/recipes/{id}")
    void deleteRecipe(@PathVariable String id) {
        recipeService.deleteById(id);
    }
}
