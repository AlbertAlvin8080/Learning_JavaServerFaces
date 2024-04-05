package org.example.validatorconversor.validator;

import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.validator.Validator;
import jakarta.faces.validator.ValidatorException;
import jakarta.inject.Named;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

@Named
@RequestScoped
public class Validators {
    private List<String> emails = Arrays.asList("lucasluco@hotmail.com", "joaosembraco@gmail.com");

    public void validateEmail(FacesContext facesContext, UIComponent uiComponent, Object o) throws ValidatorException {
        String email = (String) o;
        if(emails.contains(email)) {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "E-mail alread in use", "");
            throw new ValidatorException(message);
        }
    }
}
