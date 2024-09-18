package com.mlorenzo.inventory.services;

import java.util.List;

import com.mlorenzo.inventory.models.requests.CategoryRequestModel;
import com.mlorenzo.inventory.models.responses.CategoryRestModel;

public interface CategoryService {
	List<CategoryRestModel> getCategories();
	CategoryRestModel getCategoryById(Long id);
	CategoryRestModel saveCategory(CategoryRequestModel model);
	CategoryRestModel updateCategory(Long id, CategoryRequestModel model);
	void deleteCategory(Long id);
}
