package org.example.simplelogin.beans;

import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;
import org.example.simplelogin.estudante.Student;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

@Named
@SessionScoped
public class LoginBean implements Serializable {
    private String loginName = "";
    private String loginSurname = "";
    private String loginPassword = "";
    private Student student;
    private String language;
    private int alertCount;
    private List<Locale> locales = Arrays.asList(new Locale("en"), new Locale("pt"));

    public String login() {
        if(!loginName.isEmpty() && !loginPassword.isEmpty() && !loginSurname.isEmpty()) {
            student = new Student(loginName, loginSurname, loginPassword);
//            System.out.println(language);
            alertCount++;
            return "/restricted/main-page.xhtml?faces-redirect=true";
        }
        FacesContext instance = FacesContext.getCurrentInstance();
        instance.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
                "Please fill in the form", "details"));
        return null;
    }

    public String logout() {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "/login.xhtml?faces-redirect=true";
    }

    public String logout2() {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "/login2.xhtml?faces-redirect=true";
    }

    public String getLoginSurname() {
        return loginSurname;
    }

    public void setLoginSurname(String loginSurname) {
        this.loginSurname = loginSurname;
    }

    public int getAlertCount() {
        return alertCount;
    }

    public void setAlertCount(int alertCount) {
        this.alertCount = alertCount;
    }

    public List<Locale> getLocales() {
        return locales;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public void setLocales(List<Locale> locales) {
        this.locales = locales;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getLoginPassword() {
        return loginPassword;
    }

    public void setLoginPassword(String loginPassword) {
        this.loginPassword = loginPassword;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
