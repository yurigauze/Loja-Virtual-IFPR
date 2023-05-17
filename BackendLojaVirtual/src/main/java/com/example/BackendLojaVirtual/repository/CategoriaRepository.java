package com.example.BackendLojaVirtual.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.BackendLojaVirtual.entity.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

}
