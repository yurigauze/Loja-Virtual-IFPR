package com.example.BackendLojaVirtual.controller;

import java.io.IOException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.BackendLojaVirtual.service.ImportEstadoService;

@RestController
public class ImportEstadoController {
    private final ImportEstadoService importEstadoService;

    public ImportEstadoController(ImportEstadoService importEstadoService) {
        this.importEstadoService = importEstadoService;
    }

    @PostMapping("/importar-estados")
    public ResponseEntity<String> importarEstados(@RequestParam("file") MultipartFile file) {
        try {
            importEstadoService.importarEstados(file);
            return ResponseEntity.ok("Arquivo de estados importado com sucesso.");
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erro ao importar o arquivo de estados.");
        }
    }
}
