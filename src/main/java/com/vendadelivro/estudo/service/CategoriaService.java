package com.vendadelivro.estudo.service;

import com.vendadelivro.estudo.exception.DuplicateFieldException;
import com.vendadelivro.estudo.model.Categoria;

public interface CategoriaService {
    Categoria createNewCategory(final Categoria categoria) throws DuplicateFieldException;
}
