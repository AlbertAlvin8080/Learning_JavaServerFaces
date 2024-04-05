package org.example.communication.beans;

import jakarta.annotation.PostConstruct;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import org.omnifaces.cdi.Param;

import java.io.Serializable;
import java.util.Map;

@Named
@ViewScoped
public class CommunicationBean2 implements Serializable {
    @Inject @Param(name = "name")
    private String name;
    @Inject @Param(name = "surname")
    private String surname;

    @PostConstruct
    private void init() {
        FacesContext instance = FacesContext.getCurrentInstance();
        System.out.println("InitParameter: " +
                instance
                        .getExternalContext()
                        .getInitParameter("images.location")
        );

//        Map<String, String> parameterMap = instance.getExternalContext().getRequestParameterMap();
//        name = parameterMap.get("name");
//        surname = parameterMap.get("surname");
//        System.out.println(name);
//        System.out.println(surname);
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
