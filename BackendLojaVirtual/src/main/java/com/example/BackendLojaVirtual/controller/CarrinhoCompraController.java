package com.example.BackendLojaVirtual.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.BackendLojaVirtual.entity.CarrinhoCompra;
import com.example.BackendLojaVirtual.service.CarrinhoCompraService;

@RestController
@RequestMapping("/api/carrinhocompra")
@CrossOrigin
public class CarrinhoCompraController {

    @Autowired
    private CarrinhoCompraService carrinhoCompraService;

    @GetMapping("/get")
    public List<CarrinhoCompra> buscarTodos() {
        return carrinhoCompraService.buscarTodos();
    }

    @PostMapping("/post")
    public CarrinhoCompra inserir(@RequestBody CarrinhoCompra carrinhoCompra) {
        return carrinhoCompraService.inserir(carrinhoCompra);

    }

    @PutMapping("/alterar")
    public CarrinhoCompra alterar(@RequestBody CarrinhoCompra carrinhoCompra) {
        return carrinhoCompraService.alterar(carrinhoCompra);

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> excluirCarrinhoCompra(@PathVariable Long id) {
        try {
            carrinhoCompraService.excluir(id);
            return ResponseEntity.ok("Estado excluído com sucesso");
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<CarrinhoCompra> buscarPorId(@PathVariable("id") Long id) {
        return ResponseEntity.ok(carrinhoCompraService.buscarPorId(id));
    }
}