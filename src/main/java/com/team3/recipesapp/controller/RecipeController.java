package com.team3.recipesapp.controller;

import com.team3.recipesapp.model.Recipe;
import com.team3.recipesapp.model.User;
import com.team3.recipesapp.service.RecipeService;
import com.team3.recipesapp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class RecipeController {
    @Autowired
    private final RecipeService recipeService;

    @GetMapping("/recipes")
    public String recipes(){
        return "recipes";
    }

    @PostMapping("/recipe")
    public Recipe addRecipe(@RequestBody Recipe recipe){
        Recipe newRecipe = new Recipe(recipe.getTitle(),recipe.getInstructions(),recipe.getIngredients(),recipe.getTags());
        return recipeService.saveRecipe(newRecipe);
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
