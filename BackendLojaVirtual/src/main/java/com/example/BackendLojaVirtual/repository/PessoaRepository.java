package com.example.BackendLojaVirtual.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.BackendLojaVirtual.entity.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

}
