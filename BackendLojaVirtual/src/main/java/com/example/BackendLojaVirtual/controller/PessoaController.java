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

import com.example.BackendLojaVirtual.entity.Pessoa;
import com.example.BackendLojaVirtual.service.PessoaService;

@RestController
@RequestMapping("/api/pessoa")
@CrossOrigin
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;

    @GetMapping("/get")
    public List<Pessoa> buscarTodos() {
        return pessoaService.buscarTodos();
    }

    @PostMapping("/post")
    public Pessoa inserir(@RequestBody Pessoa pessoa) {
        return pessoaService.inserir(pessoa);

    }

    @PutMapping("/alterar")
    public Pessoa alterar(@RequestBody Pessoa pessoa) {
        return pessoaService.alterar(pessoa);

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> excluirPessoa(@PathVariable Long id) {
        try {
            pessoaService.excluir(id);
            return ResponseEntity.ok("Pessoa excluída com sucesso");
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Pessoa> buscarPorId(@PathVariable("id") Long id) {
        return ResponseEntity.ok(pessoaService.buscarPorId(id));
    }
}
