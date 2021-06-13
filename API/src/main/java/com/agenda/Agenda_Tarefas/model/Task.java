package com.agenda.Agenda_Tarefas.model;
import com.agenda.Agenda_Tarefas.service.FormatDateService;

import javax.persistence.*;
import java.io.Serializable;
import java.text.ParseException;
import java.util.Date;

@Entity
@Table(name="tasks")
public class Task implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private long id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "remenber", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date remenber;

    @Column(name = "completed")
    private boolean completed;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="OWNER_ID")
    private User owner;

    public Task(Long id, String title, String description, String remenber) throws ParseException {
        this.id = id;
        this.title = title;
        this.description = description;
        this.remenber = FormatDateService.format(remenber);
    }

    public Task() {

    }

    public Task(String title, String description, String remenber, boolean completed, User owner) throws ParseException {
        System.out.println(remenber);
        this.title = title;
        this.description = description;
        this.remenber = FormatDateService.format(remenber);
        this.completed = completed;
        this.owner = owner;
        System.out.println(this.remenber);
    }

    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRemenber() throws ParseException {
        return remenber.toString();
    }

    public void setRemenber(String remenber) throws ParseException {
        this.remenber = FormatDateService.format(remenber);
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public User getOwner(){
        return owner;
    }

    public void setOwner(User user){
        this.owner = owner;
    }

}
