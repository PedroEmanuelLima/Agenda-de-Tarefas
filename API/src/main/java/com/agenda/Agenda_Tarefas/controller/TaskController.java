package com.agenda.Agenda_Tarefas.controller;

import com.agenda.Agenda_Tarefas.dto.TaskModifiDTO;
import com.agenda.Agenda_Tarefas.dto.TaskRegistrationDTO;
import com.agenda.Agenda_Tarefas.model.Task;
import com.agenda.Agenda_Tarefas.service.TaskRegistrationService;
import com.agenda.Agenda_Tarefas.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;

@RestController
public class TaskController {

    private TaskRegistrationService taskRegistrationService;
    private TaskService taskService;

    @Autowired
    public TaskController(TaskRegistrationService taskRegistrationService, TaskService taskService) {
        this.taskRegistrationService = taskRegistrationService;
        this.taskService = taskService;
    }

    public TaskController() {

    }

    // Post create user
    @PostMapping("/new_task")
    public ResponseEntity<TaskRegistrationDTO> createTask(@RequestBody TaskRegistrationDTO taskRegistrationDTO) throws ParseException {
        Task task = taskRegistrationService.registrate(taskRegistrationDTO.toTask());
        return new ResponseEntity<TaskRegistrationDTO>(TaskRegistrationDTO.toDTO(task), HttpStatus.CREATED);
    }

    // PUT check task
    @PutMapping("/modifi/{id}")
    public ResponseEntity<Boolean> modifiInfo(@RequestBody TaskModifiDTO taskModifiDTO, @PathVariable Long id) throws ParseException {
        taskService.modifiTask(taskModifiDTO, id);
        return new ResponseEntity<Boolean>(true, HttpStatus.OK);
    }

    // PUT check task
    @GetMapping("/check_task/{id}")
    public ResponseEntity<Boolean> chekTask(@PathVariable Long id) {
        boolean modified = taskService.check(id);
        return new ResponseEntity<Boolean>(modified, HttpStatus.OK);
    }

    // DELETE task
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> deleteTask(@PathVariable Long id) {
        boolean deleted = taskService.delete(id);
        return  new ResponseEntity<Boolean>(!deleted, HttpStatus.OK);
    }


}