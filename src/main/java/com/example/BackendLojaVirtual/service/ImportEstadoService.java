package com.example.BackendLojaVirtual.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.BackendLojaVirtual.entity.Estado;
import com.example.BackendLojaVirtual.repository.EstadoRepository;

@Service
public class ImportEstadoService {
    private final EstadoRepository estadoRepository;

    public ImportEstadoService(EstadoRepository estadoRepository) {
        this.estadoRepository = estadoRepository;
    }

    public void importarEstados(MultipartFile file) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(file.getInputStream()));
        String line;
        int lineNumber = 0;
        while ((line = reader.readLine()) != null) {
            if (lineNumber != 0) { // Ignora a primeira linha
                String[] data = line.split(",");

                //substitui as primeiras linhas
                String nome = data[1].replaceAll("\"", "");
                String sigla = data[2].replaceAll("\"", "");
                String status = data[3].replaceAll("\"", "");

                boolean converter;
                if (status.equals("1")) {
                    converter = true;
                } else {
                    converter = false;
                }

                Estado estado = new Estado();
                estado.setNome(nome);
                estado.setSigla(sigla);
                estado.setStatus(converter);
                estadoRepository.saveAndFlush(estado);
            }
            lineNumber++;
        }

        reader.close();

    }
}
