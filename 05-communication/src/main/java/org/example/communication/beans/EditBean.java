package org.example.communication.beans;

import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import org.example.communication.student.Student;

import java.io.Serializable;

@Named
@ViewScoped
public class EditBean implements Serializable {
    private Student student;

    public void init() {
        student = (Student) FacesContext.getCurrentInstance().getExternalContext().getApplicationMap().get("student");
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
