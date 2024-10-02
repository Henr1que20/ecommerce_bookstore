package com.vendadelivro.estudo.service.impl;

import com.vendadelivro.estudo.model.Autor;
import com.vendadelivro.estudo.repo.AutorRepository;
import com.vendadelivro.estudo.service.AutorService;
import com.vendadelivro.estudo.exception.DuplicateFieldException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AutorServiceImpl implements AutorService {

    private AutorRepository autorRepositor;

    @Autowired
    public AutorServiceImpl(AutorRepository autorRepositor) {
        this.autorRepositor = autorRepositor;
    }

    @Override
    public Autor criarNovoAutor(final Autor autor) throws DuplicateFieldException {
        validateUniqueEmail(autor.getEmail());
        return autorRepositor.save(autor);
    }

    private void validateUniqueEmail(final String email) throws DuplicateFieldException {
        final Optional<Autor> autor = autorRepositor.findByEmail(email);
        if(autor.isPresent()){
            throw new DuplicateFieldException("Email exitente, por favor use outro email para cadastro!!");
        }
    }
}
