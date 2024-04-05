package org.example.communication.beans;

import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import org.example.communication.student.Student;

import java.io.Serializable;
import java.util.List;

@Named
@ViewScoped
public class CommunicationBean7 implements Serializable {
    private List<Student> studentList = Student.studentList();

    public String toPage8(int idx) {
        Student student = studentList.get(idx);
        FacesContext.getCurrentInstance().getExternalContext().getFlash().put("student", student);
        return "communication8?faces-redirect=true";
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }
}
