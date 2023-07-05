package com.example.BackendLojaVirtual.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.BackendLojaVirtual.entity.Produto;



public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    List<Produto> findByNomeMarca(String marca);

    List<Produto> findByNomeMarcaContaining(String parteNomeMarca);

    List<Produto> findByNomeCategoria(String categoria);

    List<Produto> findByNomeCategoriaContaining(String parteNomeCategoria);

    @Query("SELECT p FROM Produto p JOIN p.marca m JOIN p.categoria c WHERE c.nome = :nomeCategoria AND m.nome = :nomeMarca")
    List<Produto> findByNomeCategoriaAndNomeMarca(String nomeCategoria, String nomeMarca);
}
