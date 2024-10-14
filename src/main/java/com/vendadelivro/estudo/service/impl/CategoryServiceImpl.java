package com.vendadelivro.estudo.service.impl;

import com.vendadelivro.estudo.exception.DuplicateFieldException;
import com.vendadelivro.estudo.model.Category;
import com.vendadelivro.estudo.repo.CategoryRepository;
import com.vendadelivro.estudo.service.CategoryService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {

    private CategoryRepository categoryRepository;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Category createNewCategory(final Category category) throws DuplicateFieldException {
        return categoryRepository.save(category);
    }

    @Override
    public Category findCategoryById(final Long categoriaId) {
        /// adicionar tratamento para optinal
        final Optional<Category> category = Optional.ofNullable(categoryRepository.findById(categoriaId)
                .orElseThrow(() -> new EntityNotFoundException("Category Not Found!")));
        return category.get();
    }
}
