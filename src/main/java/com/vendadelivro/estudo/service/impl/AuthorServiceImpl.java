package com.vendadelivro.estudo.service.impl;

import com.vendadelivro.estudo.model.Author;
import com.vendadelivro.estudo.repo.AuthorRepository;
import com.vendadelivro.estudo.service.AuthorService;
import com.vendadelivro.estudo.exception.DuplicateFieldException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthorServiceImpl implements AuthorService {

    private AuthorRepository authorRepository;

    @Autowired
    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public Author criarNovoAutor(final Author author) throws DuplicateFieldException {
        return authorRepository.save(author);
    }

    public Author findAuthorById(final Long authorId) {
        final Optional<Author> author = Optional.ofNullable(authorRepository.findById(authorId)
                .orElseThrow(() -> new EntityNotFoundException("Author Not Found!")));
        return author.get();
    }
}
