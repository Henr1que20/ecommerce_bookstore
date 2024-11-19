package com.vendadelivro.estudo.controller;

import com.vendadelivro.estudo.dto.request.AuthorDTO;
import com.vendadelivro.estudo.model.Author;
import com.vendadelivro.estudo.service.AuthorService;
import com.vendadelivro.estudo.exception.DuplicateFieldException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/autor")
public class AuthorController {

//    tbm podemos usar o EntityManager para persistir os dados na base
//    @PersistenceContext
//    private EntityManager manager;
    
    private AuthorService service;

    @Autowired
    public AuthorController(AuthorService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Author> criarNovoAutor(@RequestBody @Valid AuthorDTO authorDTO) throws DuplicateFieldException {
        Author author = authorDTO.toModel();
        author = service.criarNovoAutor(author);
        //manager.persist(autor);
        return ResponseEntity.ok(author);
    }
}
