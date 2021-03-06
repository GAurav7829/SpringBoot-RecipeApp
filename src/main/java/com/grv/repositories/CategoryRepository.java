package com.grv.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.grv.model.Category;

public interface CategoryRepository extends CrudRepository<Category, Long> {
	Optional<Category> findByDescription(String description);
}
