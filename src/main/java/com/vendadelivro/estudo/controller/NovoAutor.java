package com.vendadelivro.estudo.controller;

import com.vendadelivro.estudo.dto.NovoAutorDTO;
import com.vendadelivro.estudo.model.Autor;
import com.vendadelivro.estudo.repo.AutorRepository;
import com.vendadelivro.estudo.service.AutorService;
import com.vendadelivro.estudo.service.exception.EmailException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/autor")
public class NovoAutor {

//    tbm podemos usar o EntityManager para persistir os dados na base
//    @PersistenceContext
//    private EntityManager manager;

    /*
    * O que deve ser feito na proxima pegada:
    *   criar o exception handler
    *   add esse codigo no git
    *
    * */

    
    private AutorService service;

    @Autowired
    public NovoAutor(AutorService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Autor> criarNovoAutor(@RequestBody @Valid NovoAutorDTO novoAutorDTO) throws EmailException {
        Autor autor = novoAutorDTO.toModel();
        autor = service.criarNovoAutor(autor);
        //manager.persist(autor);
        return ResponseEntity.ok(autor);
    }
}
