package com.vendadelivro.estudo.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.vendadelivro.estudo.model.Book;
import com.vendadelivro.estudo.validator.UniqueValue;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    private String sumario;
    private double preco;
    @Size(min = 100, message = "Numero de paginas e obrigatoria e o minimo e de 100")
    private Integer numPagina;
    @NotBlank
    private String isbn;
    @Future
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    private LocalDateTime datPublication;
    @NotNull
    private Long autorId;
    @NotNull
    private Long categoriaId;

    public Book toModel() {
        return new Book(this.titulo, this.resumo, this.sumario, this.preco, this.numPagina, this.isbn,
                this.datPublication);
    }
}
