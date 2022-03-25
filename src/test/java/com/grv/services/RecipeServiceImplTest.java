package com.grv.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import com.grv.model.Recipe;
import com.grv.repositories.RecipeRepository;

@SpringBootTest
class RecipeServiceImplTest {
	
	RecipeServiceImpl recipeService;
	@Mock
	RecipeRepository recipeRepository;

	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.openMocks(this);
		recipeService = new RecipeServiceImpl(recipeRepository);
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

}
