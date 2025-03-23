package com.alisson.gerenciador_de_tarefas.repositories;

import com.alisson.gerenciador_de_tarefas.entities.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TarefaRepository extends JpaRepository<Tarefa, Long> {
}
