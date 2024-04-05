package org.example.communication.beans;

import jakarta.faces.context.FacesContext;
import jakarta.faces.context.Flash;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import org.example.communication.student.Student;
import org.omnifaces.util.Faces;

import java.io.Serializable;

@Named
@ViewScoped
public class CommunicationBean9 implements Serializable {
    private String key;
    private String value;

    public void showCookie() {
        System.out.println(Faces.getRequestCookie(key) + " ["+key+"]:[" + value + "]" );
    }

    public void saveCookie() {
        Faces.addResponseCookie(key, value, -1);
    }

    public String toPage10() {
        return "communication10?faces-redirect=true";
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
