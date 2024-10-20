package com.vendadelivro.estudo.dto;

import com.vendadelivro.estudo.model.Author;
import com.vendadelivro.estudo.validator.UniqueValue;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class NovoAutorDTO {
    @NotBlank
    private String nome;
    @Email
    @UniqueValue(domainClass = Author.class, fieldName = "email")
    private String email;
    @NotBlank
    @Size(max = 400)
    private String descricao;

    public NovoAutorDTO() {
    }

    public NovoAutorDTO(String nome, String email, String descricao) {
        this.nome = nome;
        this.email = email;
        this.descricao = descricao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return "NovoAutorDTO{" +
                "nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", descricao='" + descricao + '\'' +
                '}';
    }

    public Author toModel() {
        return new Author(this.nome, this.email, this.descricao);
    }
}
