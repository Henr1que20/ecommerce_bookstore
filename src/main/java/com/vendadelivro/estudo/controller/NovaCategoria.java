package com.vendadelivro.estudo.controller;

import com.vendadelivro.estudo.dto.NovaCategoriaDTO;
import com.vendadelivro.estudo.dto.response.CategoriaResponseDTO;
import com.vendadelivro.estudo.exception.DuplicateFieldException;
import com.vendadelivro.estudo.model.Category;
import com.vendadelivro.estudo.service.CategoryService;
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

    private CategoryService categoryService;

    @Autowired
    public NovaCategoria(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping
    public ResponseEntity<CategoriaResponseDTO> createNewCategory(@RequestBody @Valid final NovaCategoriaDTO categoriaDTO)
            throws DuplicateFieldException {
        Category category = categoriaDTO.toModel();
        category = categoryService.createNewCategory(category);
        final CategoriaResponseDTO categoriaResponseDTO =
                new CategoriaResponseDTO(category.getId(), category.getNomeCategoria());
        return ResponseEntity.ok().body(categoriaResponseDTO);
    }

}
