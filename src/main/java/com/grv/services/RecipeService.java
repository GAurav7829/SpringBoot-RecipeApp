package com.grv.services;

import java.util.Set;

import com.grv.commands.RecipeCommand;
import com.grv.model.Recipe;

public interface RecipeService {
	Set<Recipe> getRecipies();
	Recipe findById(Long id);
	RecipeCommand findCommandById(Long id);
	RecipeCommand saveRecipeCommand(RecipeCommand command);
	void deleteById(Long id);
}
