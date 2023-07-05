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

import com.example.BackendLojaVirtual.entity.CarrinhoCompraProduto;
import com.example.BackendLojaVirtual.service.CarrinhoCompraProdutoService;

@RestController
@RequestMapping("/api/carrinhocompraproduto")
@CrossOrigin
public class CarrinhoCompraProdutoController {

    @Autowired
    private CarrinhoCompraProdutoService arrinhoCompraProdutoService;

    @GetMapping("/get")
    public List<CarrinhoCompraProduto> buscarTodos() {
        return arrinhoCompraProdutoService.buscarTodos();
    }

    @PostMapping("/post")
    public CarrinhoCompraProduto inserir(@RequestBody CarrinhoCompraProduto arrinhoCompraProduto) {
        return arrinhoCompraProdutoService.inserir(arrinhoCompraProduto);

    }

    @PutMapping("/alterar")
    public CarrinhoCompraProduto alterar(@RequestBody CarrinhoCompraProduto arrinhoCompraProduto) {
        return arrinhoCompraProdutoService.alterar(arrinhoCompraProduto);

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> excluirCarrinhoCompraProduto(@PathVariable Long id) {
        try {
            arrinhoCompraProdutoService.excluir(id);
            return ResponseEntity.ok("Estado excluído com sucesso");
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<CarrinhoCompraProduto> buscarPorId(@PathVariable("id") Long id) {
        return ResponseEntity.ok(arrinhoCompraProdutoService.buscarPorId(id));
    }
}