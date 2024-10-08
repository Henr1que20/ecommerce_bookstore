package com.vendadelivro.estudo.dto;

import com.vendadelivro.estudo.model.Categoria;
import com.vendadelivro.estudo.validator.UniqueValue;
import jakarta.validation.constraints.NotBlank;

public class NovaCategoriaDTO {

    @NotBlank
    @UniqueValue(domainClass = Categoria.class, fieldName = "nomeCategoria")
    private String nome;

    public NovaCategoriaDTO() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "NovaCategoriaDTO{" +
                "nome='" + nome + '\'' +
                '}';
    }

    public Categoria toModel(){
        return new Categoria(this.nome);
    }

}
