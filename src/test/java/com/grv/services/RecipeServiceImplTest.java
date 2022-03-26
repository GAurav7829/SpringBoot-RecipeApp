package com.grv.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import com.grv.convertors.RecipeCommandToRecipe;
import com.grv.convertors.RecipeToRecipeCommand;
import com.grv.model.Recipe;
import com.grv.repositories.RecipeRepository;

@SpringBootTest
class RecipeServiceImplTest {
	
	RecipeServiceImpl recipeService;
	@Mock
	RecipeRepository recipeRepository;
	@Mock
    RecipeToRecipeCommand recipeToRecipeCommand;
    @Mock
    RecipeCommandToRecipe recipeCommandToRecipe;

	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.openMocks(this);
		recipeService = new RecipeServiceImpl(recipeRepository, recipeCommandToRecipe, recipeToRecipeCommand);
	}
	
	@Test
	void testGetRecipeById() {
		Long idVal = 1l;
		
		Recipe recipe = new Recipe();
		recipe.setId(idVal);
		Optional<Recipe> recipeOptional = Optional.of(recipe);
		
		when(recipeRepository.findById(anyLong())).thenReturn(recipeOptional);
		Recipe getRecipe = recipeService.findById(idVal);
		
		assertNotNull(getRecipe, "Null Recipe returned");
		verify(recipeRepository, times(1)).findById(idVal);
		verify(recipeRepository, never()).findAll();
	}

	@Test
	void testGetRecipies() {
		Recipe recipe = new Recipe();
		HashSet<Recipe> recipesData = new HashSet<>();
		recipesData.add(recipe);
		
		when(recipeRepository.findAll()).thenReturn(recipesData);
		
		Set<Recipe> recipes = recipeService.getRecipies();
		assertEquals(1, recipes.size());
		verify(recipeRepository, times(1)).findAll();
	}
	
	@Test
	void testDeleteById() {
		Long idToDelete = 2l;
		recipeService.deleteById(idToDelete);
		verify(recipeRepository, times(1)).deleteById(anyLong());
	}

}
