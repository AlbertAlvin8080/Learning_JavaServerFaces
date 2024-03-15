package org.example.datatable.validator;

import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.validator.ValidatorException;
import jakarta.inject.Named;
import jakarta.servlet.http.Part;
import org.example.datatable.student.Student;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

@Named
@RequestScoped
public class Validators implements Serializable {
    private List<String> emails = Student.studentList().stream().map(Student::getEmail).collect(Collectors.toList());

    public void validateEmail(FacesContext facesContext, UIComponent uiComponent, Object o) throws ValidatorException {
        String s = (String) o;
        if (emails.contains(s)) {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Duplicated e-mail", "");
            throw new ValidatorException(message);
        }
    }

    public void validateFile(FacesContext facesContext, UIComponent uiComponent, Object o) throws ValidatorException {
        Part filePart = (Part) o;
        try {
            _validateFileContentType(filePart);
            _validateFileSize(filePart);
        } catch (RuntimeException e) {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Invalid File", e.getMessage());
            throw new ValidatorException(message);
        }
    }

    private void _validateFileContentType(Part filePart) {
        if(!filePart.getContentType().matches("image/(png|webp|jpe?g)")) {
            throw new RuntimeException("The file must be of type:\n.png, .webp or .jpeg/jpg");
        }
    }

    private void _validateFileSize(Part filePart) {
        final int size = 1_048_576;
        if(filePart.getSize() > size) {
            throw new RuntimeException("The file must be less than 1MB");
        }
    }
}
