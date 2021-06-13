package com.agenda.Agenda_Tarefas.model;
import com.agenda.Agenda_Tarefas.service.EncriptyService;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="users")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "email", unique = true, nullable = false)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "token")
    private String token;

    @OneToMany(mappedBy="owner")
    private List<Task> task;

    public User(Long id, String name, String email, String password){
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = EncriptyService.encriptyPassword(password);
    }

    public User() {

    }

    public User(String name, String email, String password) {
        super();
        this.name = name;
        this.email = email;
        this.password = EncriptyService.encriptyPassword(password);
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public List<Task> getTasks() {
        return task;
    }
}
