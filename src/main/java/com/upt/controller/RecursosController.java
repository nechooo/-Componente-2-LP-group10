package com.upt.lp.controller;

import com.upt.lp.Recursos;
import com.upt.lp.service.RecursosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/recursos")
public class RecursosController {

    @Autowired
    private RecursosService recursosService;

    @GetMapping
    public List<Recursos> getAllRecursos() {
        return recursosService.getAllRecursos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Recursos> getRecursoById(@PathVariable int id) {
        Optional<Recursos> recurso = recursosService.getRecursoById(id);
        return recurso.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Recursos> createRecurso(@RequestBody Recursos recurso) {
        try {
            Recursos novoRecurso = recursosService.createRecurso(recurso);
            return ResponseEntity.ok(novoRecurso);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Recursos> updateRecurso(@PathVariable int id, @RequestBody Recursos recursoAtualizado) {
        Optional<Recursos> recurso = recursosService.updateRecurso(id, recursoAtualizado);
        return recurso.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRecurso(@PathVariable int id) {
        recursosService.deleteRecurso(id);
        return ResponseEntity.noContent().build();
    }

}
