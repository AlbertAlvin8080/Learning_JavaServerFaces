package org.example.datatable.bean;

import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import org.example.datatable.student.Student;

import java.io.Serializable;

@Named
@ViewScoped
public class PassThroughBean implements Serializable {
    private Student student;

    public void init() {
        student = new Student();
    }

    public void save() {
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage("Data saved", student.toString())
        );
    }

    public void toUpperCase() {
        student.setName(student.getName().toUpperCase());
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
