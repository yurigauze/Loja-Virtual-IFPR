package com.example.BackendLojaVirtual.service;

import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.BackendLojaVirtual.entity.CarrinhoCompra;
import com.example.BackendLojaVirtual.repository.CarrinhoCompraRepository;

@Service
public class CarrinhoCompraService {

    @Autowired
    private CarrinhoCompraRepository carrinhoCompraRepository;

    public List<CarrinhoCompra> buscarTodos() {
        return carrinhoCompraRepository.findAll();
    }

    public CarrinhoCompra buscarPorId(Long id) {
        return carrinhoCompraRepository.findById(id).get();
    }
    public CarrinhoCompra inserir(CarrinhoCompra objeto) {
        objeto.setDataCriacao(new Date());
        CarrinhoCompra objetoNovo = carrinhoCompraRepository.saveAndFlush(objeto);
        return objetoNovo;

    }

    public CarrinhoCompra alterar(CarrinhoCompra objeto) {
        objeto.setDataAtualizacao(new Date());
        return carrinhoCompraRepository.saveAndFlush(objeto);

    }

    public void excluir(Long id) {
        CarrinhoCompra carrinhoCompra = carrinhoCompraRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Carrinho não encontrada."));
        carrinhoCompraRepository.delete(carrinhoCompra);

    }
}
