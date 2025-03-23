package com.alisson.gerenciador_de_tarefas.services;

import com.alisson.gerenciador_de_tarefas.entities.Tarefa;
import com.alisson.gerenciador_de_tarefas.exceptions.IllegalArgumentsException;
import com.alisson.gerenciador_de_tarefas.repositories.TarefaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TarefaService {

    private final TarefaRepository tarefaRepository;

    public Tarefa criarTarefa(Tarefa tarefa) {

        LocalDate dataVencimento = LocalDate.parse(tarefa.getDataVencimento());
        LocalDate dataAtual = LocalDate.parse(tarefa.getDataCriacao());

        List<String> statusValidos = Arrays.asList("INICIADA, NAO_INICIADA, CONCLUIDA");

            if (tarefa.getTitulo().isEmpty()) {
                throw new IllegalArgumentsException("O título da tarefa é obrigatório!");
            }
            if (dataVencimento.isBefore(dataAtual)) {
                throw new IllegalArgumentsException("Data de vencimento não pode ser anterior à data atual!");
            }
            if (!statusValidos.contains(tarefa.getStatus())) {
                throw new IllegalArgumentsException("O status da tarefa é inválido!");
            }

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
