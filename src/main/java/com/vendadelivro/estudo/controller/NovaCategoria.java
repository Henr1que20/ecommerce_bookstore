package com.vendadelivro.estudo.controller;

import com.vendadelivro.estudo.dto.NovaCategoriaDTO;
import com.vendadelivro.estudo.dto.response.CategoriaResponseDTO;
import com.vendadelivro.estudo.exception.DuplicateFieldException;
import com.vendadelivro.estudo.model.Categoria;
import com.vendadelivro.estudo.service.CategoriaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/categorias")
public class NovaCategoria {

    private CategoriaService categoriaService;

    @Autowired
    public NovaCategoria(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    @PostMapping
    public ResponseEntity<CategoriaResponseDTO> createNewCategory(@RequestBody @Valid final NovaCategoriaDTO categoriaDTO)
            throws DuplicateFieldException {
        Categoria categoria = categoriaDTO.toModel();
        categoria = categoriaService.createNewCategory(categoria);
        final CategoriaResponseDTO categoriaResponseDTO =
                new CategoriaResponseDTO(categoria.getId(), categoria.getNomeCategoria());
        return ResponseEntity.ok().body(categoriaResponseDTO);
    }

}
