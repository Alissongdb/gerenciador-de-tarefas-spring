package com.alisson.gerenciador_de_tarefas.controller;

import com.alisson.gerenciador_de_tarefas.entities.Tarefa;
import com.alisson.gerenciador_de_tarefas.services.TarefaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;

@RestController
@RequestMapping("/tarefa")
@RequiredArgsConstructor
@Tag(name = "Tarefas", description = "API para gerenciamento de tarefas")
public class TarefaController {

    private final TarefaService tarefaService;

    @Operation(summary = "Cria uma nova tarefa", responses = {
            @ApiResponse(responseCode = "201", description = "Tarefa criada com sucesso"),
            @ApiResponse(responseCode = "400", description = "Requisição inválida")
    })
    @PostMapping
    public ResponseEntity<Tarefa> criarTarefa(@RequestBody Tarefa tarefa) {
        return ResponseEntity.status(HttpStatus.CREATED).body(tarefaService.criarTarefa(tarefa));
    }

    @Operation(summary = "Consulta todas as tarefas", responses = {
            @ApiResponse(responseCode = "202", description = "Tarefas retornadas com sucesso")
    })
    @GetMapping
    public ResponseEntity<List<Tarefa>> consultarTarefa() {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(tarefaService.consultarTarefa());
    }

    @Operation(summary = "Atualiza uma tarefa existente", responses = {
            @ApiResponse(responseCode = "201", description = "Tarefa atualizada com sucesso"),
            @ApiResponse(responseCode = "404", description = "Tarefa não encontrada")
    })
    @PutMapping("/{id}")
    public ResponseEntity<Tarefa> atualizarTarefa(@PathVariable Long id, @RequestBody Tarefa novaTarefa) {
        Tarefa tarefaAtualizada = tarefaService.atualizarTarefa(id, novaTarefa);
        return ResponseEntity.status(HttpStatus.CREATED).body(tarefaAtualizada);
    }

    @Operation(summary = "Deleta uma tarefa", responses = {
            @ApiResponse(responseCode = "202", description = "Tarefa deletada com sucesso"),
            @ApiResponse(responseCode = "404", description = "Tarefa não encontrada")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity deletarTarefa(@PathVariable Long id) {
        tarefaService.deletarTarefa(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }
}
