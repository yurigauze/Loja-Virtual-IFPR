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

import com.example.BackendLojaVirtual.entity.Marca;
import com.example.BackendLojaVirtual.service.MarcaService;

@RestController
@RequestMapping("/api/marca")
@CrossOrigin
public class MarcaController {

    @Autowired
    private MarcaService marcaService;

    @GetMapping("/get")
    public List<Marca> buscarTodos() {
        return marcaService.buscarTodos();
    }

    @PostMapping("/post")
    public Marca inserir(@RequestBody Marca marca) {
        return marcaService.inserir(marca);

    }

    @PutMapping("/alterar")
    public Marca alterar(@RequestBody Marca marca) {
        return marcaService.alterar(marca);

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> excluirMarca(@PathVariable Long id) {
        try {
            marcaService.excluir(id);
            return ResponseEntity.ok("Marca excluída com sucesso");
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Marca> buscarPorId(@PathVariable("id") Long id) {
        return ResponseEntity.ok(marcaService.buscarPorId(id));
    }
}
