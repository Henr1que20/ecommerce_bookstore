package com.vendadelivro.estudo.service;

import com.vendadelivro.estudo.model.Autor;
import com.vendadelivro.estudo.exception.EmailException;

public interface AutorService {
    Autor criarNovoAutor(Autor autor) throws EmailException;
}
