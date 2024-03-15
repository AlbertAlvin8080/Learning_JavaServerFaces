package org.example.communication.beans;

import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;

import java.io.Serializable;
import java.util.Date;

@Named
@ViewScoped
public class CommunicationBean4 implements Serializable {
    private String name;
    private String surname;
    private Date date;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void init() {
        System.out.println(name);
        System.out.println(surname);
        System.out.println(date);
    }

    public String toPage5() {
        return "communication5?faces-redirect=true&amp;includeViewParams=true";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
}
