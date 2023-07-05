package com.example.BackendLojaVirtual.service;

import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.BackendLojaVirtual.entity.CarrinhoCompraProduto;
import com.example.BackendLojaVirtual.repository.CarrinhoCompraProdutoRepository;

@Service
public class CarrinhoCompraProdutoService {

    @Autowired
    private CarrinhoCompraProdutoRepository carrinhoCompraProdutoRepository;

    public List<CarrinhoCompraProduto> buscarTodos() {
        return carrinhoCompraProdutoRepository.findAll();
    }

    public CarrinhoCompraProduto buscarPorId(Long id) {
        return carrinhoCompraProdutoRepository.findById(id).get();
    }
    public CarrinhoCompraProduto inserir(CarrinhoCompraProduto objeto) {
        objeto.setDataCriacao(new Date());
        CarrinhoCompraProduto objetoNovo = carrinhoCompraProdutoRepository.saveAndFlush(objeto);
        return objetoNovo;

    }

    public CarrinhoCompraProduto alterar(CarrinhoCompraProduto objeto) {
        objeto.setDataAtualizacao(new Date());
        return carrinhoCompraProdutoRepository.saveAndFlush(objeto);

    }

    public void excluir(Long id) {
        CarrinhoCompraProduto carrinhoCompraProduto = carrinhoCompraProdutoRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Carrinho não encontrada."));
        carrinhoCompraProdutoRepository.delete(carrinhoCompraProduto);

    }
}