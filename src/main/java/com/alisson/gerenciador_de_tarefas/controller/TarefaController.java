package com.alisson.gerenciador_de_tarefas.controller;

import com.alisson.gerenciador_de_tarefas.entities.Tarefa;
import com.alisson.gerenciador_de_tarefas.services.TarefaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tarefa")
@RequiredArgsConstructor
public class TarefaController {

    private final TarefaService tarefaService;

    @PostMapping
    public ResponseEntity<Tarefa> criarTarefa(@RequestBody Tarefa tarefa) {
        return ResponseEntity.status(HttpStatus.CREATED).body(tarefaService.criarTarefa(tarefa));
    }

    @GetMapping
    public ResponseEntity<List<Tarefa>> consultarTarefa(@RequestBody Tarefa tarefa) {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(tarefaService.consultarTarefa());
    }

    @PutMapping
    public ResponseEntity<Tarefa> atualizarTarefa(@PathVariable Long id, @RequestBody Tarefa novaTarefa) {
        Tarefa tarefaAtualizada = tarefaService.atualizarTarefa(id, novaTarefa);
        return ResponseEntity.status(HttpStatus.CREATED).body(tarefaAtualizada);
    }

    @DeleteMapping
    public ResponseEntity deletarTarefa(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }
}
