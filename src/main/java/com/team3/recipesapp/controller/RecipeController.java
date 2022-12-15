package com.team3.recipesapp.controller;

import com.team3.recipesapp.model.Recipe;
import com.team3.recipesapp.service.RecipeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
@RequiredArgsConstructor
public class RecipeController {
    @Autowired
    private final RecipeService recipeService;

    @RequestMapping("/recipes/{id}")
    public String viewRecipe(@PathVariable String id, Model model) {

        Recipe recipe = recipeService.getRecipeByID(id);

        model.addAttribute("recipe", recipe);

        return "recipes";
    }

    @RequestMapping("/photos/{id}")
    public ResponseEntity<byte[]> viewPhoto(@PathVariable String id) {

        Recipe recipe = recipeService.getRecipeByID(id);

        byte[] imageBytes = recipe.getPhoto();

        HttpHeaders headers = new HttpHeaders();

        headers.setContentType(MediaType.IMAGE_JPEG);

        return new ResponseEntity<>(imageBytes, headers, HttpStatus.OK);
    }

    @GetMapping("/recipes")
    public String showRecipe(){
        return "recipes";
    }
    @GetMapping("/createrecipe")
    public String addRecipe(){
        return "createrecipe";
    }

    @PostMapping("/createrecipe")
    public String submitRecipe(@RequestParam("imageFile")MultipartFile imageFile,@RequestParam("title") String title,
                              @RequestParam("ingredients") String ingredients,@RequestParam("description") String description,@RequestParam("instructions") String instructions,
                              @RequestParam("tags") String tags){
        try {
            recipeService.saveRecipe(imageFile,title,ingredients,description,instructions,tags);
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
    public String replacerecipe(@RequestBody Recipe newRecipe, @PathVariable String id) {
        recipeService.replaceRecipe(newRecipe,id);

        return "home";
    }


    @DeleteMapping(path = "/recipe/{id}")
    void deleteRecipe(@PathVariable String id) {
        recipeService.deleteById(id);
    }
}
