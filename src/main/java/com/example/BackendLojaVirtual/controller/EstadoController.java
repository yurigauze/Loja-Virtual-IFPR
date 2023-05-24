package com.example.BackendLojaVirtual.controller;

import java.io.IOException;
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
import org.springframework.web.multipart.MultipartFile;

import com.example.BackendLojaVirtual.entity.Estado;
import com.example.BackendLojaVirtual.service.EstadoService;
import com.example.BackendLojaVirtual.service.ImportEstadoService;

import jakarta.annotation.Generated;
import jakarta.websocket.server.PathParam;

@RestController
@RequestMapping("/api/estado")
@CrossOrigin
public class EstadoController {

    @Autowired
    private EstadoService estadoService;
    
    @GetMapping("/get")
    public List<Estado> buscarTodos() {
        return estadoService.buscarTodos();
    }

    @PostMapping("/post")
    public Estado inserir(@RequestBody Estado estado) {
        return estadoService.inserir(estado);

    }

    @PutMapping("/alterar")
    public Estado alterar(@RequestBody Estado estado) {
        return estadoService.alterar(estado);

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> excluirEstado(@PathVariable Long id) {
        try {
            estadoService.excluir(id);
            return ResponseEntity.ok("Estado excluído com sucesso");
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Estado> buscarPorId(@PathVariable("id") Long id) {
        return ResponseEntity.ok(estadoService.buscarPorId(id));
    }

    @Autowired
    private ImportEstadoService importEstadoService;

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
