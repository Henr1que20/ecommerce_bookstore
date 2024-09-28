package com.vendadelivro.estudo.service.impl;

import com.vendadelivro.estudo.model.Autor;
import com.vendadelivro.estudo.repo.AutorRepository;
import com.vendadelivro.estudo.service.AutorService;
import com.vendadelivro.estudo.service.exception.EmailException;
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
    public Autor criarNovoAutor(Autor autor) throws EmailException {
        validateUniqueEmail(autor);
        autor = autorRepositor.save(autor);
        return autor;
    }

    private void validateUniqueEmail(Autor autor) throws EmailException {
        Optional<Autor> autor1 = autorRepositor.findByEmail(autor.getEmail());
        if(autor1.isPresent()){
            throw new EmailException("Email exitente, por favor use outro email para cadastro!!");
        }
    }
}
