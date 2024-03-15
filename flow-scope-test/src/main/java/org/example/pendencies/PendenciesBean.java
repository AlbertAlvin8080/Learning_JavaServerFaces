package org.example.pendencies;

import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.flow.FlowScoped;
import jakarta.inject.Named;

import java.io.Serializable;

@Named
@FlowScoped(value = "pendencies")
public class PendenciesBean implements Serializable {
    private String name;
    private String surname;

    public String validate() {
        System.out.println("Validating data...");
        if (false) {
            FacesContext instance = FacesContext.getCurrentInstance();
            instance.addMessage(null, new FacesMessage(
                    FacesMessage.SEVERITY_ERROR, "Invalid Fields", "*Details*"));
            return null;
        }
        return "continueRegistration";
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
