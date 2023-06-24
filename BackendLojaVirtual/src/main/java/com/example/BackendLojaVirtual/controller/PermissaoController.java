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

import com.example.BackendLojaVirtual.entity.Permissao;
import com.example.BackendLojaVirtual.service.PermissaoService;

@RestController
@RequestMapping("/api/permissao")
@CrossOrigin
public class PermissaoController {

    @Autowired
    private PermissaoService permissaoService;

    @GetMapping("/get")
    public List<Permissao> buscarTodos() {
        return permissaoService.buscarTodos();
    }

    @PostMapping("/post")
    public Permissao inserir(@RequestBody Permissao permissao) {
        return permissaoService.inserir(permissao);

    }

    @PutMapping("/alterar")
    public Permissao alterar(@RequestBody Permissao permissao) {
        return permissaoService.alterar(permissao);

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> excluirCategoria(@PathVariable Long id) {
        try {
            permissaoService.excluir(id);
            return ResponseEntity.ok("Permissão excluída com sucesso");
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Permissao> buscarPorId(@PathVariable("id") Long id) {
        return ResponseEntity.ok(permissaoService.buscarPorId(id));
    }
}
