package com.vendadelivro.estudo.controller;

import com.vendadelivro.estudo.dto.BookDTO;
import com.vendadelivro.estudo.model.Book;
import com.vendadelivro.estudo.service.BookService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/livros")
public class NovoLivro {

    private BookService livroService;

    @Autowired
    public NovoLivro(BookService livroService) {
        this.livroService = livroService;
    }

    @PostMapping
    public ResponseEntity<Book> registerNewBook(@RequestBody @Valid BookDTO dto){
        var livro = livroService.registerNewBook(dto);
        return ResponseEntity.ok().body(livro);
    }
}
