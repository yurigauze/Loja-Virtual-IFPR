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
        while ((line = reader.readLine()) != null) {
            String[] data = line.split(",");

            String nome = data[1];
            String sigla = data[2];
            String status = data[3];
            boolean converter = Boolean.parseBoolean(status);

            Estado estado = new Estado(nome, sigla, converter);
            estadoRepository.saveAndFlush(estado);
        }

        reader.close();
    }
}
