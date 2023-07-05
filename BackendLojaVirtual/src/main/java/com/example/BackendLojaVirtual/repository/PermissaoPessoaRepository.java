package com.example.BackendLojaVirtual.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.BackendLojaVirtual.entity.PermissaoPessoa;
import com.example.BackendLojaVirtual.entity.Pessoa;

public interface PermissaoPessoaRepository extends JpaRepository<PermissaoPessoa, Long> {

    List<Pessoa> findByCidadeId(Long idCidade);

    List<PermissaoPessoa> findByPermissaoId(Long id);

}
