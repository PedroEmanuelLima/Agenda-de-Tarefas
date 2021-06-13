package com.agenda.Agenda_Tarefas.service;

import com.agenda.Agenda_Tarefas.model.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class TokenService {

    // Tempo de 30 minutos para validade de um token
    private static final long expirationTime = 1800000;

    // Hash aleatório para chave do token
    private String key = "716bf0d1098fb42995721713a797fc6f"; // MD5 de Application_Agenda_de_Tarefas_MD5__

    public String generatetoken(User user){
        return Jwts.builder()
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setSubject(user.getId().toString())
                .setExpiration(new Date(System.currentTimeMillis() + expirationTime))
                .signWith(SignatureAlgorithm.HS256, key)
                .compact();
    }

    public Claims decodeToken(String token) {
        return Jwts.parser()
                .setSigningKey(key)
                .parseClaimsJws(token)
                .getBody();
    }

}
