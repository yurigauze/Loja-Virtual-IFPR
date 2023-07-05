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

import com.example.BackendLojaVirtual.entity.Pessoa;
import com.example.BackendLojaVirtual.entity.Produto;
import com.example.BackendLojaVirtual.service.ProdutoService;

@RestController
@RequestMapping("/api/produto")
@CrossOrigin
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @GetMapping("/get")
    public List<Produto> buscarTodos() {
        return produtoService.buscarTodos();
    }

    @PostMapping("/post")
    public Produto inserir(@RequestBody Produto produto) {
        return produtoService.inserir(produto);

    }

    @PutMapping("/alterar")
    public Produto alterar(@RequestBody Produto produto) {
        return produtoService.alterar(produto);

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> excluirProduto(@PathVariable Long id) {
        try {
            produtoService.excluir(id);
            return ResponseEntity.ok("Produto excluído com sucesso");
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Produto> buscarPorId(@PathVariable("id") Long id) {
        return ResponseEntity.ok(produtoService.buscarPorId(id));
    }

    //Testar
    @GetMapping("/buscar-por-marca")
    public ResponseEntity<List<Produto>> findByNomeMarca(@RequestParam("nomeMarca")String marca){
        return ResponseEntity.ok(produtoService.findByNomeMarca(marca));
    }
        //Testar
    @GetMapping("/buscar-por-marca-contendo")
    public ResponseEntity<List<Produto>> findByNomeMarcaContaining(@RequestParam("nomeMarca")String marca){
        return ResponseEntity.ok(produtoService.findByNomeMarcaContaining(marca));
    }

        @GetMapping("/buscar-por-categoria")
    public ResponseEntity<List<Produto>> findByNomeCatgoria(@RequestParam("nomeCategoria")String categoria){
        return ResponseEntity.ok(produtoService.findByNomeCategoria(categoria));
    }
        //Testar
    @GetMapping("/buscar-por-categoria-contendo")
    public ResponseEntity<List<Produto>> findByNomeContaining(@RequestParam("nomeCategoria")String categoria){
        return ResponseEntity.ok(produtoService.findByNomeCategoriaContaining(categoria));
    }

    @GetMapping("/buscar-por-categoria-e-marca")
    public ResponseEntity<List<Produto>> findByNomeCategoriaAndNomeMarca(@RequestParam("nomeCategoria") String nomeCategoria, @RequestParam("nomeMarca") String nomeMarca) {
        List<Produto> produtos = produtoService.buscarProdutosPorCategoriaEMarca(nomeCategoria, nomeMarca);
        return ResponseEntity.ok(produtos);
    }
}
