package org.example.communication.beans;

import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import org.example.communication.student.Student;
import org.omnifaces.util.Faces;

import java.io.Serializable;
import java.util.List;

@Named
@ViewScoped
public class CommunicationBean11 implements Serializable {
    private List<Student> students = Student.studentList();

    public void remove(Student student) {
        students.remove(student);
    }

    // DO NOT use this frequently
    public String edit(Student student) {
        FacesContext.getCurrentInstance().getExternalContext().getApplicationMap().put("student", student);
        return "edit?faces-redirect=true";
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}
