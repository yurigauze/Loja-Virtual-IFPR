package com.example.BackendLojaVirtual.controller;

import java.io.IOException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.BackendLojaVirtual.service.ImportCidadeService;



@RestController
public class ImportCidadeController {
    private final ImportCidadeService importCidadeService;

    public ImportCidadeController(ImportCidadeService importCidadeService) {
        this.importCidadeService = importCidadeService;
    }

    @PostMapping("/importar-cidades")
    public ResponseEntity<String> importarCidade(@RequestParam("file") MultipartFile file) {
        try {
            importCidadeService.importarCidade(file);
            return ResponseEntity.ok("Arquivo de cidades importado com sucesso.");
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erro ao importar o arquivo de cidades.");
        }
    }
}