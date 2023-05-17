package com.example.BackendLojaVirtual.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.BackendLojaVirtual.entity.Cidade;
import com.example.BackendLojaVirtual.service.CidadeService;


@RestController
@RequestMapping("/api/cidade")
public class CidadeController {

    @Autowired
    private CidadeService cidadeService;

    @GetMapping("/get")
    public List<Cidade> buscarTodos() {
        return cidadeService.buscarTodos();
    }

    @PostMapping("/post")
    public Cidade inserir(@RequestBody Cidade cidade) {
        return cidadeService.inserir(cidade);

    }

    @PutMapping("/alterar")
    public Cidade alterar(@RequestBody Cidade cidade) {
        return cidadeService.alterar(cidade);

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> excluir(@PathVariable("id") Long id) {
        cidadeService.excluir(id);
        return ResponseEntity.ok().build();
    }
}
