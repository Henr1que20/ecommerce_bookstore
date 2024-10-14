package com.vendadelivro.estudo.service;

import com.vendadelivro.estudo.exception.DuplicateFieldException;
import com.vendadelivro.estudo.model.Category;

public interface CategoryService {
    Category createNewCategory(final Category category) throws DuplicateFieldException;

    Category findCategoryById(final Long categoriaId);
}
