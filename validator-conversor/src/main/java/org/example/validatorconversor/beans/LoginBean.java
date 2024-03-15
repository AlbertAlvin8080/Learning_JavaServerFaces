package org.example.validatorconversor.beans;

import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

@Named
@SessionScoped
public class LoginBean implements Serializable {
    private String email = "";
    private boolean logged;
    private List<Locale> locales = Arrays.asList(new Locale("pt"), new Locale("en"));
    private String language;

    public String login() {
        if(!email.isEmpty()) {
            logged = true;
            return "restricted/main-page.xhtml?faces-redirect=true";
        }
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_ERROR, "Invalid Fields", ""));
        return null;
    }

    public String logout() {
        logged = false;
        return "/login.xhtml?faces-redirect=true";
    }

    public List<Locale> getLocales() {
        return locales;
    }

    public void setLocales(List<Locale> locales) {
        this.locales = locales;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public boolean isLogged() {
        return logged;
    }

    public void setLogged(boolean logged) {
        this.logged = logged;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
