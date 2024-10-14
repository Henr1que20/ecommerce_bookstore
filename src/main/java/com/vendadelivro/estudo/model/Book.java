package com.vendadelivro.estudo.model;

import com.vendadelivro.estudo.dto.NovaCategoriaDTO;
import com.vendadelivro.estudo.dto.NovoAutorDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "tb_livro")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;

    private String resumo;
    private String sumario;

    // estudar a possibilidade de usar o biginteger
    private double preco;
    private int numPagina;
    private String isbn;
    private LocalDateTime datPublication;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Category category;
    @OneToOne(cascade = CascadeType.ALL)
    private Author author;

    public Book(String titulo, String resumo, String sumario, double preco, int numPagina, String isbn, LocalDateTime datPublication, NovoAutorDTO autor, NovaCategoriaDTO categoria) {
        this.titulo = titulo;
        this.resumo = resumo;
        this.sumario = sumario;
        this.preco = preco;
        this.numPagina = numPagina;
        this.isbn = isbn;
        this.datPublication = datPublication;
        this.author = autor.toModel();
        this.category = categoria.toModel();
    }

    public Book(String titulo, String resumo, String sumario, double preco, int numPagina, String isbn, LocalDateTime datPublication) {
        this.titulo = titulo;
        this.resumo = resumo;
        this.sumario = sumario;
        this.preco = preco;
        this.numPagina = numPagina;
        this.isbn = isbn;
        this.datPublication = datPublication;
    }
}
