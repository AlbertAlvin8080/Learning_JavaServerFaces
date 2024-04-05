package org.example.communication.beans;

import jakarta.faces.context.FacesContext;
import jakarta.faces.event.ActionEvent;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;

import java.io.Serializable;
import java.util.Map;

@Named
@ViewScoped
public class CommunicationBean6 implements Serializable {
    private String name;
    private String surname;
    private String text = "meu-texto";

    public String getText() {
        return text;
    }

    public void exec(ActionEvent event) {
        Map<String, Object> map = event.getComponent().getAttributes();
        System.out.println(map.get("value"));
        System.out.println(map.get("testing"));
    }

    public void printNames() {
        System.out.println("--- printNames ---");
        System.out.println(name);
        System.out.println(surname);
        System.out.println("------------------");
//        return "";
    }

    public String toPage6() {
        return "communication6?faces-redirect=true&amp;includeViewParams=true";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        System.out.println("Dentro do setName");
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        System.out.println("Dentro do setSurname");
        this.surname = surname;
    }
}
