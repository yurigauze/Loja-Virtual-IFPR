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

import com.example.BackendLojaVirtual.entity.Categoria;
import com.example.BackendLojaVirtual.service.CategoriaService;

@RestController
@RequestMapping("/api/categoria")
@CrossOrigin
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping("/get")
    public List<Categoria> buscarTodos() {
        return categoriaService.buscarTodos();
    }

    @PostMapping("/post")
    public Categoria inserir(@RequestBody Categoria categoria) {
        return categoriaService.inserir(categoria);

    }

    @PutMapping("/alterar")
    public Categoria alterar(@RequestBody Categoria categoria) {
        return categoriaService.alterar(categoria);

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> excluirCategoria(@PathVariable Long id) {
        try {
            categoriaService.excluir(id);
            return ResponseEntity.ok("Estado excluído com sucesso");
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Categoria> buscarPorId(@PathVariable("id") Long id) {
        return ResponseEntity.ok(categoriaService.buscarPorId(id));
    }
}
