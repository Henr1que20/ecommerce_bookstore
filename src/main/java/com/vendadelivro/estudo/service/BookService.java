package com.vendadelivro.estudo.service;

import com.vendadelivro.estudo.dto.BookDTO;
import com.vendadelivro.estudo.model.Book;

public interface BookService {
    Book registerNewBook(BookDTO dto);
}
