package org.example.beans;

import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import org.example.student.Student;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Named
@SessionScoped
public class SessionBean implements Serializable {
    private List<String> disciplines = Arrays.asList("Math", "Boiology", "I. To Progr.");
    private List<String> selectedDisciplines = new ArrayList<>();
    private Student student = new Student();

    public void selectDiscipline() {
        int idx = ThreadLocalRandom.current().nextInt(disciplines.size());
        selectedDisciplines.add(disciplines.get(idx));
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public List<String> getDisciplines() {
        return disciplines;
    }

    public void setDisciplines(List<String> disciplines) {
        this.disciplines = disciplines;
    }

    public List<String> getSelectedDisciplines() {
        return selectedDisciplines;
    }

    public void setSelectedDisciplines(List<String> selectedDisciplines) {
        this.selectedDisciplines = selectedDisciplines;
    }
}
