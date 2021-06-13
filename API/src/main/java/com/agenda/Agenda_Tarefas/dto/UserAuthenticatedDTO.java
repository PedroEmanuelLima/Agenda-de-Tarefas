package com.agenda.Agenda_Tarefas.dto;

import com.agenda.Agenda_Tarefas.model.Task;
import com.agenda.Agenda_Tarefas.model.User;

import java.util.List;

public class UserAuthenticatedDTO {
    private String type;
    private Long id;
    private String email;
    private String name;
    private List<Task> tasks;
    private String token;

    public UserAuthenticatedDTO(Long id, String email, String name, String token, List<Task> tasks, String type) {

        this.id = id;
        this.email = email;
        this.name = name;
        this.token = token;
        this.tasks = tasks;
        this.type = type;
    }

    public UserAuthenticatedDTO(){}

    public static UserAuthenticatedDTO toDTO(User user, String type) {
        return new UserAuthenticatedDTO(user.getId(),user.getEmail(), user.getName(), user.getToken(), user.getTasks(), type);
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getToken() {
        return token;
    }

    public String getType() {
        return type;
    }
}