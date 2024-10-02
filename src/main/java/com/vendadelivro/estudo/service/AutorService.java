package com.vendadelivro.estudo.service;

import com.vendadelivro.estudo.model.Autor;
import com.vendadelivro.estudo.exception.DuplicateFieldException;

public interface AutorService {
    Autor criarNovoAutor(final Autor autor) throws DuplicateFieldException;
}
