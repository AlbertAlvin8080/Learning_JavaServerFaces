package org.example.customtags.validators;

import jakarta.faces.application.FacesMessage;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.validator.FacesValidator;
import jakarta.faces.validator.Validator;
import jakarta.faces.validator.ValidatorException;

@FacesValidator(value = "emailValidator")
public class EmailValidator implements Validator {
    @Override
    public void validate(FacesContext facesContext, UIComponent uiComponent, Object o) throws ValidatorException {
        String email = (String) o;
        if(!email.matches("\\w+(\\.\\w+)*@\\w+(\\.\\w+)+")) {
            throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR,"Invalid e-mail", ""));
        }
    }
}
