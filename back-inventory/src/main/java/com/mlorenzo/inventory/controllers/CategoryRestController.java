package com.mlorenzo.inventory.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.mlorenzo.inventory.models.requests.CategoryRequestModel;
import com.mlorenzo.inventory.models.responses.CategoryRestModel;
import com.mlorenzo.inventory.services.CategoryService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("api/v1/categories")
public class CategoryRestController {
	private final CategoryService categoryService;

	@GetMapping
	public List<CategoryRestModel> getAll() {
		return categoryService.getCategories();
	}
	
	@GetMapping("{categoryId}")
	public CategoryRestModel getCategoryById(@PathVariable("categoryId") Long id) {
		return categoryService.getCategoryById(id);
	}
	
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping
	public CategoryRestModel saveCategory(@RequestBody CategoryRequestModel model) {
		return categoryService.saveCategory(model);
	}
	
	@PutMapping("{categoryId}")
	public CategoryRestModel updateCategory(@PathVariable(name = "categoryId") Long id, @RequestBody CategoryRequestModel model) {
		return categoryService.updateCategory(id, model);
	}
	
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping("{categoryId}")
	public void deleteCategory(@PathVariable Long categoryId) {
		categoryService.deleteCategory(categoryId);
	}
}
