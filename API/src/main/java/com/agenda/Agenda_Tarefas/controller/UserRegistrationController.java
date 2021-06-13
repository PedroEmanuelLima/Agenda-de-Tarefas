package com.agenda.Agenda_Tarefas.controller;

import com.agenda.Agenda_Tarefas.dto.UserAuthenticatedDTO;
import com.agenda.Agenda_Tarefas.dto.UserRegistrationDTO;
import com.agenda.Agenda_Tarefas.model.User;
import com.agenda.Agenda_Tarefas.service.UserRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserRegistrationController {

    private UserRegistrationService userRegistrationService;

    @Autowired
     public UserRegistrationController(UserRegistrationService userRegistrationService){
        this.userRegistrationService = userRegistrationService;
     }

    public UserRegistrationController(){

    }

    // Post create user
    @PostMapping("/new_user")
    public ResponseEntity<UserAuthenticatedDTO> createUser(@RequestBody UserRegistrationDTO userRegistrationDTO){
        User user = userRegistrationService.registrate(userRegistrationDTO.toUser());
        return  new ResponseEntity<UserAuthenticatedDTO>(UserAuthenticatedDTO.toDTO(user, "Bearer "), HttpStatus.CREATED);
    }

}
