package com.vendadelivro.estudo.dto.response;

public class CategoriaResponseDTO {
    private Long id;
    private String nomeCategoria;

    public CategoriaResponseDTO() {
    }

    public CategoriaResponseDTO(Long id, String nomeCategoria) {
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
