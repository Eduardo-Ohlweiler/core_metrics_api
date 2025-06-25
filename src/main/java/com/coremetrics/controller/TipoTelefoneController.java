package com.coremetrics.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.coremetrics.model.TipoTelefone;
import com.coremetrics.service.TipoTelefoneService;

@RestController
@RequestMapping("/api/tipo-telefone")
public class TipoTelefoneController {

    @Autowired
    private TipoTelefoneService tipoTelefoneService;

    @GetMapping
    public ResponseEntity<List<TipoTelefone>> listar(@RequestParam(required = false) String descricao) {
        List<TipoTelefone> lista = tipoTelefoneService.listar(descricao);
        return ResponseEntity.ok(lista);
    }

    @PostMapping
    public ResponseEntity<TipoTelefone> criar(@RequestBody TipoTelefone tipoTelefone) {
        TipoTelefone salvo = tipoTelefoneService.criar(tipoTelefone);
        return ResponseEntity.status(HttpStatus.CREATED).body(salvo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TipoTelefone> atualizar(@PathVariable Integer id, @RequestBody TipoTelefone dados) {
        try {
            TipoTelefone atualizado = tipoTelefoneService.atualizar(id, dados);
            return ResponseEntity.ok(atualizado);
        } catch (RuntimeException e) {
            if ("Acesso negado".equals(e.getMessage())) {
                return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
            } else {
                return ResponseEntity.notFound().build();
            }
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Integer id) {
        try {
            tipoTelefoneService.deletar(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            if ("Acesso negado".equals(e.getMessage())) {
                return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
            } else {
                return ResponseEntity.notFound().build();
            }
        }
    }
}
