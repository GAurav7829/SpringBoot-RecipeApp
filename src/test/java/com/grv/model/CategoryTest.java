package com.grv.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CategoryTest {
	
	Category category;
	
	@BeforeEach
	public void setUp() {
		category = new Category();
	}

	@Test
	public void testGetId() {
		Long idValue = 4l;
		category.setId(idValue);
		assertEquals(idValue, category.getId());
	}

	@Test
	public void testGetDescription() {
	}

	@Test
	public void testGetRecipes() {
	}

}
