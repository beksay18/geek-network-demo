package com.geek.controller;

import com.geek.entity.Category;
import com.geek.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class CategoryController {

	@Autowired
	private CategoryRepository categoryRepository;

	@GetMapping("/add_categories")
	public String showCategoryForm(Model model) {
		List<Category> listCategories = categoryRepository.findAll();
		model.addAttribute("category", new Category());
		model.addAttribute("listCategories", listCategories);
		return "category_form";
	}

	@PostMapping("/save_categories")
	public String saveCategories(Category category, Model model) {
		categoryRepository.save(category);

		List<Category> listCategories = categoryRepository.findAll();
		model.addAttribute("listCategories", listCategories);
		model.addAttribute("category", new Category());
		return "category_form";
	}

}
