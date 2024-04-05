package org.example.datatable.bean;

import jakarta.annotation.PostConstruct;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import jakarta.validation.constraints.*;
import org.example.datatable.student.Student;

import java.io.Serializable;

@Named
@ViewScoped
public class BeanValidatorBean implements Serializable {
    @Size(min = 3, max = 10, message = "3 <= name size <= 10")
    private String name;

//    @Pattern(regexp = "\\w+(\\.\\w+)*@\\w+(\\.\\w+)+", message = "Invalid e-mail")
    @NotNull(message = "e-mail mustn't be null")
    private String email;

    @DecimalMax(value = "10.00", message = "Grade exceeds 10.00")
    @DecimalMin(value = "0.00", message = "Grade below 0.00")
//    @Digits(integer = 2, fraction = 2, message = "")
    private float grade;

    @PostConstruct
    private void init() {}

    public void save() {
        Student student = new Student(name, email, grade);
        FacesContext.getCurrentInstance()
                .addMessage(null, new FacesMessage("Added Student", student.toString()));
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public float getGrade() {
        return grade;
    }

    public void setGrade(float grade) {
        this.grade = grade;
    }
}
