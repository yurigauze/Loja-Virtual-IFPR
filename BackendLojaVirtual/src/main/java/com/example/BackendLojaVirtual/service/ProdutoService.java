package com.example.BackendLojaVirtual.service;

import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.BackendLojaVirtual.entity.Produto;
import com.example.BackendLojaVirtual.repository.ProdutoRepository;


@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;


   public List<Produto> findByNomeMarca(String marca){
    return produtoRepository.findByNomeMarca(marca);
   }

    public List<Produto> findByNomeMarcaContaining(String parteNome){
        return produtoRepository.findByNomeMarcaContaining(parteNome);
    }

    public List<Produto> findByNomeCategoria(String categoria){
    return produtoRepository.findByNomeCategoria(categoria);
   }

    public List<Produto> findByNomeCategoriaContaining(String parteNomeCategoria){
        return produtoRepository.findByNomeCategoriaContaining(parteNomeCategoria);
    }

     public List<Produto> buscarProdutosPorCategoriaEMarca(String nomeCategoria, String nomeMarca) {
        return produtoRepository.findByNomeCategoriaAndNomeMarca(nomeCategoria, nomeMarca);
     }
     
    public List<Produto> buscarTodos(){
        return produtoRepository.findAll();
    }

    public Produto buscarPorId(Long id) {
        return produtoRepository.findById(id).get();
    }

    public Produto inserir(Produto produto){
        produto.setDataCriacao(new Date());
        Produto produtoNovo = produtoRepository.saveAndFlush(produto);
        return produtoNovo;
        
    }

    public Produto alterar(Produto produto){
        produto.setDataAtualizacao(new Date());
        return produtoRepository.saveAndFlush(produto);

    }

    public void excluir(Long id) {
        Produto produto = produtoRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Produto não encontrado."));
        produtoRepository.delete(produto);

    }
    
}
