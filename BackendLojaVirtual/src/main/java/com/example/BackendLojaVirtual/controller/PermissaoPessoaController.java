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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.BackendLojaVirtual.entity.PermissaoPessoa;
import com.example.BackendLojaVirtual.entity.Pessoa;
import com.example.BackendLojaVirtual.service.PermissaoPessoaService;

@RestController
@RequestMapping("/api/permissaopessoa")
@CrossOrigin
public class PermissaoPessoaController {

    @Autowired
    private PermissaoPessoaService permissaopessoaService;

    @GetMapping("/get")
    public List<PermissaoPessoa> buscarTodos() {
        return permissaopessoaService.buscarTodos();
    }

    @PostMapping("/post")
    public PermissaoPessoa inserir(@RequestBody PermissaoPessoa permissaopessoa) {
        return permissaopessoaService.inserir(permissaopessoa);

    }

    @PutMapping("/alterar")
    public PermissaoPessoa alterar(@RequestBody PermissaoPessoa permissaopessoa) {
        return permissaopessoaService.alterar(permissaopessoa);

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> excluirMarca(@PathVariable Long id) {
        try {
            permissaopessoaService.excluir(id);
            return ResponseEntity.ok("Marca excluída com sucesso");
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<PermissaoPessoa> buscarPorId(@PathVariable("id") Long id) {
        return ResponseEntity.ok(permissaopessoaService.buscarPorId(id));
    }

        //Testar
    @GetMapping("/buscar-por-permissao")
    public ResponseEntity<List<PermissaoPessoa>> findByPermissaoId(@RequestParam("idPermissao")Long id){
        return ResponseEntity.ok(permissaopessoaService.buscarPermissaoId(id));
    }
}
