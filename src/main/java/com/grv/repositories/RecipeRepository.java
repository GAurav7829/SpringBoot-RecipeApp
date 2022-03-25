package com.grv.repositories;

import org.springframework.data.repository.CrudRepository;

import com.grv.model.Recipe;

public interface RecipeRepository extends CrudRepository<Recipe, Long> {

}
