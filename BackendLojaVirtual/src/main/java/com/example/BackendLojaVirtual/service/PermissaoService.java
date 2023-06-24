package com.example.BackendLojaVirtual.service;

import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.BackendLojaVirtual.entity.Permissao;
import com.example.BackendLojaVirtual.repository.PermissaoRepository;

@Service
public class PermissaoService {

    @Autowired
    private PermissaoRepository permissaoRepository;

    public List<Permissao> buscarTodos() {
        return permissaoRepository.findAll();
    }

    public Permissao buscarPorId(Long id) {
        return permissaoRepository.findById(id).get();
    }

    public Permissao inserir(Permissao permissao) {
        permissao.setDataCriacao(new Date());
        Permissao permissaoNovo = permissaoRepository.saveAndFlush(permissao);
        return permissaoNovo;

    }

    public Permissao alterar(Permissao cidade) {
        cidade.setDataAtualizacao(new Date());
        return permissaoRepository.saveAndFlush(cidade);

    }

    public void excluir(Long id) {
        Permissao permissao = permissaoRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Permissao não encontrada."));
        permissaoRepository.delete(permissao);

    }

}
