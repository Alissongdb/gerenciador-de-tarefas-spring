package com.alisson.gerenciador_de_tarefas.services;

import com.alisson.gerenciador_de_tarefas.entities.Status;
import com.alisson.gerenciador_de_tarefas.entities.Tarefa;
import com.alisson.gerenciador_de_tarefas.repositories.TarefaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class TarefaServiceTest {

    @Autowired
    private TarefaService tarefaService;

    @Autowired
    private TarefaRepository tarefaRepository;

    private Tarefa tarefa;

    @BeforeEach
    public void setUp() {
        tarefaRepository.deleteAll(); // Limpa o banco de dados entre os testes
        tarefa = new Tarefa();
        tarefa.setTitulo("Tarefa Teste");
        tarefa.setStatus(Status.CONCLUIDA);
        tarefa.setDataCriacao("2025-03-24");
        tarefa.setDataVencimento("2025-03-25");
    }

    @Test
    public void testCriarTarefa() {
        Tarefa tarefaCriada = tarefaService.criarTarefa(tarefa);

        assertEquals("Tarefa Teste", tarefaCriada.getTitulo());
        assertEquals(Status.CONCLUIDA, tarefaCriada.getStatus());
    }

    @Test
    public void testConsultarTarefa() {
        tarefaService.criarTarefa(tarefa);  // Cria uma tarefa

        var tarefas = tarefaService.consultarTarefa();
        assertEquals(1, tarefas.size());  // Verifica que temos uma tarefa
    }
}
