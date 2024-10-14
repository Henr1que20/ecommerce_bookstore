package com.vendadelivro.estudo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_categoria")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nomeCategoria;

    public Category() {
    }

    public Category(String nomeCategoria) {
        this.nomeCategoria = nomeCategoria;
    }

    public Category(Long id, String nomeCategoria) {
        this.id = id;
        this.nomeCategoria = nomeCategoria;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeCategoria() {
        return nomeCategoria;
    }

    public void setNomeCategoria(String nomeCategoria) {
        this.nomeCategoria = nomeCategoria;
    }
}
