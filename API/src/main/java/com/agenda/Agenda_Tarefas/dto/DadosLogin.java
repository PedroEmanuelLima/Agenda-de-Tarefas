package com.agenda.Agenda_Tarefas.dto;

import com.agenda.Agenda_Tarefas.model.User;

public class DadosLogin {

    private String email;
    private String password;

    public DadosLogin() {

    }

    public DadosLogin(String email, String senha) {
        this.email = email;
        this.password = senha;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}