package com.grv.repositories;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.grv.model.UnitOfMeasure;

@SpringBootTest
class UnitOfMeasureRepositoryIT {	//UnitOfMeasureRepositoryIntegrationTest
	@Autowired
	UnitOfMeasureRepository unitOfMeasureRepository;

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void testFindByDescription() {
		Optional<UnitOfMeasure> uomOptional = unitOfMeasureRepository.findByDescription("Teaspoon");
		
		assertEquals("Teaspoon", uomOptional.get().getDescription());
	}
	
	@Test
	void testFindByDescriptionCup() {
		Optional<UnitOfMeasure> uomOptional = unitOfMeasureRepository.findByDescription("Cup");
		
		assertEquals("Cup", uomOptional.get().getDescription());
	}

}
