package com.vendadelivro.estudo.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.vendadelivro.estudo.model.Book;
import com.vendadelivro.estudo.validator.UniqueValue;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BookDTO {
    @NotBlank
    @UniqueValue(domainClass = Book.class, fieldName = "titulo")
    private String titulo;
    @NotBlank
    @Size(max = 500)
    private String resumo;
    @NotBlank
    private String sumario;
    @NotNull
    @Min(20)
    private BigDecimal preco;
    @Min(100)
    private Integer numPagina;
    @NotBlank
    private String isbn;
    @Future
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    private LocalDateTime datPublication;

    // interessante criar uma validação customisada para id(@ExistId)
    @NotNull
    private Long autorId;
    @NotNull
    private Long categoriaId;

    public Book toModel() {
        return new Book(this.titulo, this.resumo, this.sumario, this.preco, this.numPagina, this.isbn,
                this.datPublication);
    }
}
