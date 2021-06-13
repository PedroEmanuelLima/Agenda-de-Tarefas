package com.agenda.Agenda_Tarefas.dto;

import com.agenda.Agenda_Tarefas.model.Task;
import com.agenda.Agenda_Tarefas.model.User;
import com.agenda.Agenda_Tarefas.service.FormatDateService;
import com.fasterxml.jackson.annotation.JsonAutoDetect;

import java.text.Format;
import java.text.ParseException;
import java.util.Date;

@JsonAutoDetect(fieldVisibility= JsonAutoDetect.Visibility.ANY)
public class TaskRegistrationDTO extends Task{

    private Long id;
    private String title;
    private String description;
    private String remenber;
    private boolean completed;
    private User owner;

    public TaskRegistrationDTO() {

    }

    public TaskRegistrationDTO(String title, String description, String remenber, boolean completed, User owner) throws ParseException {
        this.title = title;
        this.description = description;
        this.remenber = remenber;
        this.completed = completed;
        this.owner = owner;
    }

    public Task toTask() throws ParseException {
        return new Task(getTitle(), getDescription(), getRemenber(), isCompleted(), getOwner());
    }

    public static TaskRegistrationDTO toDTO(Task task) throws ParseException {
        return new TaskRegistrationDTO(task.getTitle(), task.getDescription(), task.getRemenber(), task.isCompleted(), task.getOwner());
    }

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRemenber() throws ParseException {
        return remenber;
    }

    public void setRemenber(String remenber) throws ParseException {
        this.remenber = remenber;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    @Override
    public User getOwner() {
        return owner;
    }

    @Override
    public void setOwner(User owner) {
        this.owner = owner;
    }
}