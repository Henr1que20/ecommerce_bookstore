package com.vendadelivro.estudo.service;

import com.vendadelivro.estudo.model.Author;
import com.vendadelivro.estudo.exception.DuplicateFieldException;

public interface AuthorService {
    Author criarNovoAutor(final Author author) throws DuplicateFieldException;
    Author findAuthorById(Long authorId);
}
