package com.example.BackendLojaVirtual.service;

import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.BackendLojaVirtual.entity.PermissaoPessoa;
import com.example.BackendLojaVirtual.repository.PermissaoPessoaRepository;

@Service
public class PermissaoPessoaService {

    @Autowired
    private PermissaoPessoaRepository permissaopessoaRepository;

    public List<PermissaoPessoa> buscarTodos() {
        return permissaopessoaRepository.findAll();
    }

     public List<PermissaoPessoa> buscarPermissaoId(Long idPermissao) {
        return permissaopessoaRepository.findByPermissaoId(idPermissao);
    }

    public PermissaoPessoa buscarPorId(Long id) {
        return permissaopessoaRepository.findById(id).get();
    }

    public PermissaoPessoa inserir(PermissaoPessoa permissaopessoa) {
        permissaopessoa.setDataCriacao(new Date());
        PermissaoPessoa permissaopessoaRepositoryNovo = permissaopessoaRepository.saveAndFlush(permissaopessoa);
        return permissaopessoaRepositoryNovo;

    }

    public PermissaoPessoa alterar(PermissaoPessoa permissaopessoa) {
        permissaopessoa.setDataAtualizacao(new Date());
        return permissaopessoaRepository.saveAndFlush(permissaopessoa);

    }

    public void excluir(Long id) {
        PermissaoPessoa permissaopessoa = permissaopessoaRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("PermissaoPessoa não encontrado."));
        permissaopessoaRepository.delete(permissaopessoa);

    }

}
