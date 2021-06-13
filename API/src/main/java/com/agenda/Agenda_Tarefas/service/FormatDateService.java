package com.agenda.Agenda_Tarefas.service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FormatDateService {
    public static Date format(String data) throws ParseException {
        DateFormat df = new SimpleDateFormat("dd-MM-yyyy HH:mm");
        return df.parse(data);
    }
}
