package com.vendadelivro.estudo.service;

import com.vendadelivro.estudo.dto.BookDTO;
import com.vendadelivro.estudo.dto.response.BookResponseDTO;
import com.vendadelivro.estudo.model.Book;

import java.util.List;

public interface BookService {
    Book registerNewBook(BookDTO dto);

    List<BookResponseDTO> findAllBooks();
}
