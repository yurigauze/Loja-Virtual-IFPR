package com.example.BackendLojaVirtual.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.BackendLojaVirtual.entity.Cidade;
import com.example.BackendLojaVirtual.entity.Estado;
import com.example.BackendLojaVirtual.repository.EstadoRepository;
import com.example.BackendLojaVirtual.repository.CidadeRepository;

@Service
public class ImportCidadeService {
    private final CidadeRepository cidadeRepository;
    private final EstadoRepository estadoRepository;

    public ImportCidadeService(CidadeRepository cidadeRepository, EstadoRepository estadoRepository) {
        this.cidadeRepository = cidadeRepository;
        this.estadoRepository = estadoRepository;
    }

    public void importarCidade(MultipartFile file) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(file.getInputStream()));
        String line;
        int lineNumber = 0;
        while ((line = reader.readLine()) != null) {
            if (lineNumber != 0) { // Ignora a primeira linha
                String[] data = line.split(",");

                // substitui as primeiras linhas
                String nome = data[1].replaceAll("\"", "");
                String status = data[2].replaceAll("\"", "");
                String estadoId = data[3].replaceAll("\"", "");

                boolean converter;
                if (status.equals("1")) {
                    converter = true;
                } else {
                    converter = false;
                }

                Optional<Estado> optionalEstado = estadoRepository.findById(Long.parseLong(estadoId));
                if (optionalEstado.isPresent()) {
                    Estado estado = optionalEstado.get();
                    
                    Cidade cidade = new Cidade();
                    cidade.setNome(nome);
                    cidade.setStatus(converter);
                    cidade.setEstado(estado);

                    cidadeRepository.saveAndFlush(cidade);
                } else {
                    continue;
                }
            }
            lineNumber++;
        }

        reader.close();
    }

}

