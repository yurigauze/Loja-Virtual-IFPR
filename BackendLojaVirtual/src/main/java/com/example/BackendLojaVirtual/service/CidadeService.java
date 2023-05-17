package com.example.BackendLojaVirtual.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.BackendLojaVirtual.entity.Cidade;
import com.example.BackendLojaVirtual.repository.CidadeRepository;

@Service
public class CidadeService {

    @Autowired
    private CidadeRepository cidadeRepository;

    public List<Cidade> buscarTodos() {
        return cidadeRepository.findAll();
    }

    public Cidade inserir(Cidade cidade) {
        cidade.setDataCriacao(new Date());
        Cidade cidadeNovo = cidadeRepository.saveAndFlush(cidade);
        return cidadeNovo;

    }

    public Cidade alterar(Cidade objeto) {
        objeto.setDataAtualizacao(new Date());
        return cidadeRepository.saveAndFlush(objeto);

    }

    public void excluir(Long id) {
        Cidade objeto = cidadeRepository.findById(id).get();
        cidadeRepository.delete(objeto);

    }

}
