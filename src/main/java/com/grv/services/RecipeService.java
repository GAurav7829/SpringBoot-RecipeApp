package com.grv.services;

import java.util.Set;

import com.grv.model.Recipe;

public interface RecipeService {
	Set<Recipe> getRecipies();
	Recipe findById(Long id);
}
