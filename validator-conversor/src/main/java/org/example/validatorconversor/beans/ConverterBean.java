package org.example.validatorconversor.beans;

import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import org.example.validatorconversor.student.Student;

import java.io.Serializable;
import java.util.List;

@Named
@ViewScoped
public class ConverterBean implements Serializable {
    private List<Student> studentList = Student.studentList();
    private Student student;

    public void save() {
        System.out.println("Saving student: " + student);
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }
}
