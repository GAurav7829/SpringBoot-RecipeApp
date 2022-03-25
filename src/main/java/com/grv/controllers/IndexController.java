package com.grv.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.grv.services.RecipeService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class IndexController {
	@Autowired
	private RecipeService recipeService;

	@RequestMapping({ "", "/", "/index" })
	public String getIndexPage(Model model) {
		log.info("Index page called.");
		model.addAttribute("recipies", recipeService.getRecipies());

		return "index";
	}
}
