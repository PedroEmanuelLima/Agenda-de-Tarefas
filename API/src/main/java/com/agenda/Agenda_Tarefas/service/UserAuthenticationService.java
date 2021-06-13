package com.agenda.Agenda_Tarefas.service;

import com.agenda.Agenda_Tarefas.dto.DadosLogin;
import com.agenda.Agenda_Tarefas.model.User;
import com.agenda.Agenda_Tarefas.repository.UserRepository;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UserAuthenticationService {

    private final UserRepository userRepository;
    private TokenService tokenService;

    @Autowired
    public UserAuthenticationService(UserRepository userRepository, TokenService tokenService){
        this.userRepository = userRepository;
        this.tokenService = tokenService;
    }

    public User authenticate(DadosLogin dados){
        User user = userRepository.findByEmail(dados.getEmail()).orElseThrow(RuntimeException::new);
        if(user.getPassword().equals(EncriptyService.encriptyPassword(dados.getPassword()))) {
            user.setToken(tokenService.generatetoken(user));
            return user;
        }
        else {
            throw new RuntimeException();
        }
    }

    public User authenticate(String email, String token){
        User user = userRepository.findByEmail(email).orElseThrow(RuntimeException::new);
        if(!token.isEmpty() && validate(token)) {
            return user;
        }
        else {
            throw new RuntimeException();
        }
    }

    private boolean validate(String token) {
        try {
            String tokenTratado = token.replace("Bearer ", "");
            Claims claims = tokenService.decodeToken(tokenTratado);

            //Verifica se o token está expirado
            if (claims.getExpiration().before(new Date(System.currentTimeMillis()))) throw new RuntimeException();
            return true;
        } catch (RuntimeException et){
            et.printStackTrace();
            throw et;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException ();
        }

    }

}
