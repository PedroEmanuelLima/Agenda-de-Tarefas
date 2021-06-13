package com.agenda.Agenda_Tarefas.controller;

import com.agenda.Agenda_Tarefas.dto.DadosLogin;
import com.agenda.Agenda_Tarefas.dto.UserAuthenticatedDTO;
import com.agenda.Agenda_Tarefas.model.User;
import com.agenda.Agenda_Tarefas.service.UserAuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserAuthenticationController {

    private UserAuthenticationService userAuthenticationService;

    @Autowired
    public UserAuthenticationController(UserAuthenticationService userAuthenticationService){
        this.userAuthenticationService = userAuthenticationService;
    }

    public UserAuthenticationController(){

    }

    // Post user login whith token
    @PostMapping("/login_token")
    //public ResponseEntity<UserAutheticatedDTO> authenticar(@RequestBody DadosLogin dadosLogin, @RequestHeader String Authorization) {
    public ResponseEntity<UserAuthenticatedDTO> authenticar(@RequestBody UserAuthenticatedDTO dados, @RequestHeader String Authorization) {
        User user = userAuthenticationService.authenticate(dados.getEmail(), Authorization);
        return new ResponseEntity<UserAuthenticatedDTO>(UserAuthenticatedDTO.toDTO(user, "Bearer "), HttpStatus.ACCEPTED);
    }

    // Post user login
    @PostMapping("/login")
    public ResponseEntity<UserAuthenticatedDTO> authenticar(@RequestBody DadosLogin dadosLogin) {
        User user = userAuthenticationService.authenticate(dadosLogin);
        return new ResponseEntity<UserAuthenticatedDTO>(UserAuthenticatedDTO.toDTO(user, "Bearer "), HttpStatus.ACCEPTED);
    }

}
