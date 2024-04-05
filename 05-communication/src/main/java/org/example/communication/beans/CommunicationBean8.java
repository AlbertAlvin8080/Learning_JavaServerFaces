package org.example.communication.beans;

import jakarta.faces.context.FacesContext;
import jakarta.faces.context.Flash;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import org.example.communication.student.Student;

import java.io.Serializable;
import java.util.List;

@Named
@ViewScoped
public class CommunicationBean8 implements Serializable {
    private Student student;

    public void init() {
        Flash flash = FacesContext.getCurrentInstance().getExternalContext().getFlash();
        student = (Student) flash.get("student");
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
