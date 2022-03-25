package com.grv.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;

import com.grv.model.Recipe;
import com.grv.services.RecipeService;

@SpringBootTest
class IndexControllerTest {
	
	@Mock
	RecipeService recipeService;
	@Mock
	Model model;
	IndexController controller;

	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.openMocks(this);
		controller = new IndexController(recipeService);
	}
	
	@Test
	void testMockMVC() throws Exception {
		MockMvc mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
		
		mockMvc.perform(get("/"))
			.andExpect(status().isOk())
			.andExpect(view().name("index"));
	}

	@Test
	void testGetIndexPage() {
		//given
		Set<Recipe> recipes = new HashSet<Recipe>();
		Recipe recipe1 = new Recipe();
		recipe1.setId(1l);
		recipes.add(recipe1);
		Recipe recipe2 = new Recipe();
		recipe1.setId(2l);
		recipes.add(recipe2);
		
		when(recipeService.getRecipies()).thenReturn(recipes);
		ArgumentCaptor<Set<Recipe>> argumentCaptor = ArgumentCaptor.forClass(Set.class);
		
		//when
		String viewName = controller.getIndexPage(model);
		
		//then
		assertEquals("index", viewName);
		
		verify(recipeService, times(1)).getRecipies();
		verify(model, times(1)).addAttribute(eq("recipes"), argumentCaptor.capture());
		Set<Recipe> setInController = argumentCaptor.getValue();
		assertEquals(2, setInController.size());
	}

}
