package com.grv.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.grv.commands.RecipeCommand;
import com.grv.services.RecipeService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class RecipeController {
	private final RecipeService recipeService;

	public RecipeController(RecipeService recipeService) {
		super();
		this.recipeService = recipeService;
	}
	
	@GetMapping
	@RequestMapping("/recipe/{id}/show")
	public String showById(@PathVariable Long id, Model model) {
		model.addAttribute("recipe", recipeService.findById(id));
		return "recipe/show";
	}
	
	@GetMapping
	@RequestMapping("/recipe/new")
	public String newRecipe(Model model) {
		model.addAttribute("recipe", new RecipeCommand());
		return "recipe/recipeform";
	}
	
	@GetMapping
	@RequestMapping("/recipe/{id}/update")
	public String updateRecipe(@PathVariable Long id, Model model) {
		model.addAttribute("recipe", recipeService.findCommandById(id));
		return "recipe/recipeform";
	}
	
	@PostMapping("/recipe")
	public String saveOrUpdateRecipe(@ModelAttribute RecipeCommand recipeCommand) {
		RecipeCommand savedRecipeCommand = recipeService.saveRecipeCommand(recipeCommand);
		return "redirect:/recipe/"+savedRecipeCommand.getId()+"/show";
	}
	
	@GetMapping
	@RequestMapping("/recipe/{id}/delete")
	public String deleteById(@PathVariable Long id) {
		log.debug("deleting id: "+ id);
		recipeService.deleteById(id);
		return "redirect:/";
	}
}
