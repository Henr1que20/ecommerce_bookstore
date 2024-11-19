package com.vendadelivro.estudo.controller;

import com.vendadelivro.estudo.dto.request.BookDTO;
import com.vendadelivro.estudo.dto.response.BookDetailDTO;
import com.vendadelivro.estudo.dto.response.BookResponseDTO;
import com.vendadelivro.estudo.model.Book;
import com.vendadelivro.estudo.service.BookService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    private BookService bookService;

    @Autowired
    public BookController(BookService livroService) {
        this.bookService = livroService;
    }

    @PostMapping
    public ResponseEntity<Book> registerNewBook(@RequestBody @Valid BookDTO dto){
        var livro = bookService.registerNewBook(dto);
        return ResponseEntity.ok().body(livro);
    }

    @GetMapping("/list")
    public ResponseEntity<List<BookResponseDTO>> listAllBooks(){
        var books = bookService.findAllBooks();
        return ResponseEntity.ok().body(books);
    }

    @GetMapping("/list/{id}")
    public ResponseEntity<BookDetailDTO> bookDetail(@PathVariable Long id){
        var books = bookService.findBookDetail(id);
        return ResponseEntity.ok().body(books);
    }
}
