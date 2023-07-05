package com.example.BackendLojaVirtual.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.BackendLojaVirtual.entity.CarrinhoCompraProduto;

public interface CarrinhoCompraProdutoRepository extends JpaRepository<CarrinhoCompraProduto, Long>{

    
}