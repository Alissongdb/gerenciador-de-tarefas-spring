package com.alisson.gerenciador_de_tarefas.services;

import com.alisson.gerenciador_de_tarefas.entities.Tarefa;
import com.alisson.gerenciador_de_tarefas.repositories.TarefaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TarefaService {

    private final TarefaRepository tarefaRepository;

    public Tarefa criarTarefa(Tarefa tarefa) {
        return tarefaRepository.save(tarefa);
    }

    public List<Tarefa> consultarTarefa() {
        return tarefaRepository.findAll();
    }

    public Tarefa atualizarTarefa(Long id, Tarefa novaTarefa) {
        tarefaRepository.existsById(id);
        novaTarefa.setId(id);
        return tarefaRepository.save(novaTarefa);
    }

    public void deletarTarefa(Long id) {
        tarefaRepository.deleteById(id);
    }
}
