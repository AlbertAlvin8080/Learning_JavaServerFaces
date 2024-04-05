package org.example.datatable.bean;

import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import org.example.datatable.student.Student;
import org.primefaces.PrimeFaces;
import org.primefaces.context.PrimeRequestContext;
import org.primefaces.event.RowEditEvent;

import java.io.Serializable;
import java.util.*;

@Named
@ViewScoped
public class DatatableBean implements Serializable {
    private List<Student> studentList = Student.studentList();
    private Student student = new Student();
    private boolean sorted = true;

    public void onRowEdit(RowEditEvent<Student> event) {
        FacesMessage msg = new FacesMessage("Student Edited", event.getObject().getId().toString());
//        System.out.println(event.getObject());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void onRowCancel(RowEditEvent<Student> event) {
        FacesMessage msg = new FacesMessage("Edit Cancelled", event.getObject().getId().toString());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

//    public void toAddPage() {
//        student = new Student();
//        Map<String, Object> options = new HashMap<>();
//        options.put("resizable", false);
//        options.put("modal", true);
//        String dialogClientId = "dynamicDialog_";
//        options.put("dynamicDialogId", dialogClientId);
//        PrimeFaces.current().dialog().openDynamic("addPage", options, null);
//    }

    public void openAddDialog() {
        // Deprecated
        // RequestContext.getCurrentInstance().execute("PF('" + widgetVar + "').show();");
        PrimeFaces.current().executeScript("PF('dialogAddStudent').show();");
    }

    public void add() {
        studentList.add(student);
        FacesMessage msg = new FacesMessage("Student Added", student.getName() + " " + student.getSurname());
        FacesContext.getCurrentInstance().addMessage(null, msg);

        PrimeFaces.current().executeScript("PF('dialogAddStudent').hide();");
//        PrimeFaces.current().executeScript("console.log('TESTEEEEEEEEEEE');");

        student = new Student();
    }

    public void sortByName() {
        if (sorted) {
            studentList.sort(Comparator.comparing(Student::getName));
        } else {
            studentList.sort(Comparator.comparing(Student::getName).reversed());
        }
        sorted = !sorted;
    }

    public void sortBySurname() {
        if (sorted) {
            studentList.sort(Comparator.comparing(Student::getSurname).thenComparing(Student::getName));
        } else {
            studentList.sort(Comparator.comparing(Student::getSurname).thenComparing(Student::getName).reversed());
        }
        sorted = !sorted;
    }

    public void remove(Student student) {
        System.out.println(student);
        studentList.remove(student);
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
