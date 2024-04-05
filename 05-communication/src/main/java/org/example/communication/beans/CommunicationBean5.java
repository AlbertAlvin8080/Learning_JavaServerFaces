package org.example.communication.beans;

import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;

import java.io.Serializable;

@Named
@ViewScoped
public class CommunicationBean5 implements Serializable {
    private String name;
    private String surname;

    public void init() {
        System.out.println(name);
        System.out.println(surname);
    }

    public String toPage6() {
        return "communication6?faces-redirect=true&amp;includeViewParams=true";
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
