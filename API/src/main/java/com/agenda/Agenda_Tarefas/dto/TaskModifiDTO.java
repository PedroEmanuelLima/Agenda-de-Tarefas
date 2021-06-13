package com.agenda.Agenda_Tarefas.dto;

import com.agenda.Agenda_Tarefas.model.Task;
import com.agenda.Agenda_Tarefas.model.User;
import com.fasterxml.jackson.annotation.JsonAutoDetect;

import java.text.ParseException;

@JsonAutoDetect(fieldVisibility= JsonAutoDetect.Visibility.ANY)
public class TaskModifiDTO extends Task{

    private Long id;
    private String title;
    private String description;
    private String remenber;

    public TaskModifiDTO() {

    }

    public TaskModifiDTO(String title, String description, String remenber) throws ParseException {
        this.title = title;
        this.description = description;
        this.remenber = remenber;
    }

    public static TaskModifiDTO toDTO(Task task) throws ParseException {
        return new TaskModifiDTO(task.getTitle(), task.getDescription(), task.getRemenber());
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
}