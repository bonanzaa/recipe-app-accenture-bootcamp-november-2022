package com.team3.recipesapp.repository;

import com.team3.recipesapp.model.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe,String> {
}
