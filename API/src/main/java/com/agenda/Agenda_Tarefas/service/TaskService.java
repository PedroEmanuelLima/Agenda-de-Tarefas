package com.agenda.Agenda_Tarefas.service;

import com.agenda.Agenda_Tarefas.dto.TaskModifiDTO;
import com.agenda.Agenda_Tarefas.model.Task;
import com.agenda.Agenda_Tarefas.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.Date;

@Service
public class TaskService {

    private TaskRepository taskRepository;

    @Autowired
    public TaskService(TaskRepository taskRepository){
        this.taskRepository = taskRepository;
    }

    public boolean check(Long id){
        Task task = taskRepository.findById(id).orElseThrow();
        task.setCompleted(!task.isCompleted());
        taskRepository.save(task);
        return task.isCompleted();
    }

    public boolean delete(Long id){
        Task task = taskRepository.findById(id).orElseThrow();
        taskRepository.delete(task);
        return taskRepository.existsById(id);
    }

    public Task modifiTask(TaskModifiDTO taskModifiDTO, Long id) throws ParseException {
        Task task = taskRepository.findById(id).orElseThrow();
        task.setTitle(taskModifiDTO.getTitle());
        task.setDescription(taskModifiDTO.getDescription());
        task.setRemenber(taskModifiDTO.getRemenber());
        taskRepository.save(task);
        return task;
    }

}