package com.agenda.Agenda_Tarefas.service;

import com.agenda.Agenda_Tarefas.model.User;
import com.agenda.Agenda_Tarefas.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserRegistrationService {

    private UserRepository userRepository;
    private TokenService tokenService;

    @Autowired
    public UserRegistrationService(UserRepository userRepository, TokenService tokenService){
        this.userRepository = userRepository;
        this.tokenService = tokenService;
    }

    public User registrate(User user){
        user.setToken(tokenService.generatetoken(user));
        return userRepository.save(user);
    }

}