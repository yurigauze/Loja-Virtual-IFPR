package com.example.BackendLojaVirtual.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.BackendLojaVirtual.entity.Cidade;
import com.example.BackendLojaVirtual.entity.Permissao;
import com.example.BackendLojaVirtual.entity.Pessoa;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

    List<Pessoa> findByCidadeId(Long idCidade);

    List<Pessoa> findByPermissoes_Permissao(Permissao permissao);


}
