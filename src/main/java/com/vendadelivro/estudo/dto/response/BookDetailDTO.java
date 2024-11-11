package com.vendadelivro.estudo.dto.response;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record BookDetailDTO(
        String titulo,
        BigDecimal price,
        String bookAbstract,
        String sumary,
        int numberPages,
        String isbn,
        LocalDateTime puplicationDate,
        AuthorResponseDTO author) {
}
