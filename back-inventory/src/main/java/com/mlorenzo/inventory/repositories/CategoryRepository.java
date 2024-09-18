package com.mlorenzo.inventory.repositories;

import org.springframework.data.repository.CrudRepository;

import com.mlorenzo.inventory.domain.Category;

public interface CategoryRepository extends CrudRepository<Category, Long> {

}
