package com.vendadelivro.estudo.service.impl;

import com.vendadelivro.estudo.dto.BookDTO;
import com.vendadelivro.estudo.model.Author;
import com.vendadelivro.estudo.model.Book;
import com.vendadelivro.estudo.model.Category;
import com.vendadelivro.estudo.repo.BookRepository;
import com.vendadelivro.estudo.service.AuthorService;
import com.vendadelivro.estudo.service.BookService;
import com.vendadelivro.estudo.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {

    private BookRepository bookRepository;
    private AuthorService authorService;
    private CategoryService categoryService;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository, AuthorService authorService, CategoryService categoryService) {
        this.bookRepository = bookRepository;
        this.authorService = authorService;
        this.categoryService = categoryService;
    }

    @Override
    public Book registerNewBook(final BookDTO dto) {
        final var author = authorService.findAuthorById(dto.getAutorId());
        final var category = categoryService.findCategoryById(dto.getCategoriaId());
        var book = dto.toModel();
        book.setAuthor(author);
        book.setCategory(category);
        return bookRepository.save(book);
    }


}
