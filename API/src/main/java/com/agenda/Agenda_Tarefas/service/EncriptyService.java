package com.agenda.Agenda_Tarefas.service;

import java.math.BigInteger;
import java.security.MessageDigest;

public class EncriptyService {

    public static String encriptyPassword(String password){
        String response = "";
        MessageDigest md;
        try {
            md = MessageDigest.getInstance("MD5");
            BigInteger hash = new BigInteger(1, md.digest(password.getBytes()));
            response = hash.toString(16);
        }
        catch (Exception e){ }
        return response;
    }

}
