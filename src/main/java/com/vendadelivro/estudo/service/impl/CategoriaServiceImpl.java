package com.vendadelivro.estudo.service.impl;

import com.vendadelivro.estudo.exception.DuplicateFieldException;
import com.vendadelivro.estudo.model.Categoria;
import com.vendadelivro.estudo.repo.CategoriaRepository;
import com.vendadelivro.estudo.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoriaServiceImpl implements CategoriaService {

    private CategoriaRepository categoriaRepository;

    @Autowired
    public CategoriaServiceImpl(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    @Override
    public Categoria createNewCategory(final Categoria categoria) throws DuplicateFieldException {
        validateUniqueCategoria(categoria.getNomeCategoria());
        return categoriaRepository.save(categoria);
    }

    private void validateUniqueCategoria(final String nomeCategoria) throws DuplicateFieldException {
        final Optional<Categoria> categoria = categoriaRepository.findByNomeCategoria(nomeCategoria);
        if(categoria.isPresent()){
            throw new DuplicateFieldException("Categoria existente, por favor cadastre outra categoria!!");
        }
    }
}
