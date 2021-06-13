package com.agenda.Agenda_Tarefas.repository;

import com.agenda.Agenda_Tarefas.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
}
