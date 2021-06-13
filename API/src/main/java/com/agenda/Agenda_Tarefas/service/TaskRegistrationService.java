package com.agenda.Agenda_Tarefas.service;

import com.agenda.Agenda_Tarefas.model.Task;
import com.agenda.Agenda_Tarefas.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskRegistrationService {

    private TaskRepository taskRepository;

    @Autowired
    public TaskRegistrationService(TaskRepository taskRepository){
        this.taskRepository = taskRepository;
    }

    public Task registrate(Task task){
        return taskRepository.save(task);
    }

}