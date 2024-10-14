package com.vendadelivro.estudo.repo;

import com.vendadelivro.estudo.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    Optional<Category> findByNomeCategoria(String nomeCategoria);
}
