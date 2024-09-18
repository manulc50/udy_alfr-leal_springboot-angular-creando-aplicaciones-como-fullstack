package com.mlorenzo.inventory.services;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.mlorenzo.inventory.domain.Category;
import com.mlorenzo.inventory.models.requests.CategoryRequestModel;
import com.mlorenzo.inventory.models.responses.CategoryRestModel;
import com.mlorenzo.inventory.repositories.CategoryRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class CategoryServiceImp implements CategoryService {
	private final CategoryRepository categoryRepository;

	@Override
	public List<CategoryRestModel> getCategories() {
		return ((List<Category>)categoryRepository.findAll()).stream()
				.map(c -> new CategoryRestModel(c.getId(), c.getName(), c.getDescription()))
				.toList();
	}

	@Override
	public CategoryRestModel getCategoryById(Long id) {
		return categoryRepository.findById(id)
				.map(c -> new CategoryRestModel(c.getId(), c.getName(), c.getDescription()))
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Category with id " + id + " not found"));
	}

	@Override
	public CategoryRestModel saveCategory(CategoryRequestModel model) {
		Category savedCategory = categoryRepository.save(new Category(model.getName(), model.getDescription()));
		return new CategoryRestModel(savedCategory.getId(), savedCategory.getName(), savedCategory.getDescription());
	}

	@Override
	public CategoryRestModel updateCategory(Long id, CategoryRequestModel model) {
		return categoryRepository.findById(id)
				.map(cat -> {
					cat.setName(model.getName());
					cat.setDescription(model.getDescription());
					Category updatedCategory = categoryRepository.save(cat);
					return new CategoryRestModel(updatedCategory.getId(), updatedCategory.getName(), updatedCategory.getDescription());
				})
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Category with id " + id + " not found"));
	}

	@Override
	public void deleteCategory(Long id) {
		if(categoryRepository.existsById(id))
			categoryRepository.deleteById(id);
		else
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Category with id " + id + " not found");
	}

}
