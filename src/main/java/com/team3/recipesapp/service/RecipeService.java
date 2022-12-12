package com.team3.recipesapp.service;

import com.team3.recipesapp.model.Recipe;
import com.team3.recipesapp.model.User;
import com.team3.recipesapp.repository.RecipeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RecipeService {
    private final RecipeRepository recipeRepository;

    public List<Recipe> getRecipes(){
        return recipeRepository.findAll();
    }

    public Recipe saveRecipe(Recipe recipe){
        return recipeRepository.save(recipe);
    }

    public void delete(Recipe recipe){ recipeRepository.delete(recipe);}
    public void deleteById(String id){
        recipeRepository.deleteById(id);
    }

    public Recipe replaceRecipe(Recipe newRecipe,String id){
        return recipeRepository.findById(id)
                .map(recipe -> {
                    recipe.setTitle(newRecipe.getTitle());
                    recipe.setInstructions(newRecipe.getInstructions());
                    recipe.setIngredients(newRecipe.getIngredients());
                    recipe.setTags(newRecipe.getTags());
                    recipe.setCreationTime(newRecipe.getCreationTime());

                    return recipeRepository.save(recipe);
                })
                .orElseGet(() -> {
                    newRecipe.setId(id);
                    return recipeRepository.save(newRecipe);
                });
    }

}
