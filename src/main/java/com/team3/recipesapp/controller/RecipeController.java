package com.team3.recipesapp.controller;

import com.azure.core.annotation.Get;
import com.team3.recipesapp.model.Recipe;
import com.team3.recipesapp.model.User;
import com.team3.recipesapp.service.RecipeService;
import com.team3.recipesapp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class RecipeController {
    @Autowired
    private final RecipeService recipeService;

    @GetMapping("/recipe")
    public String addRecipe(){
        return "recipe";
    }

    @PostMapping("/recipe")
    public String submitRecipe(@RequestParam("imageFile")MultipartFile imageFile,@RequestParam("title") String title,
                              @RequestParam("ingredients") String ingredients,@RequestParam("instructions") String instructions,
                              @RequestParam("tags") String tags){
        try {
            recipeService.saveRecipe(imageFile,title,ingredients,instructions,tags);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return "home";
    }
    @GetMapping("/recipelist")
    public String getRecipeList(Model model){

        model.addAttribute("recipes",recipeService.getRecipes());
        return "allrecipes";
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
