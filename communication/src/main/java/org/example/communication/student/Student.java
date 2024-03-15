package org.example.communication.student;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Student {
    public static List<Student> studentList() {
        return new ArrayList<>(
                Arrays.asList(
                        new Student("Klaus", "Poppe", 3.4f),
                        new Student("Dead", "Cells", 8.1f),
                        new Student("Insufferable", "Crypt", 7.4f)
                ));
    }

    private String name;
    private String surname;
    private float grade1;

    public Student(String name, String surname, float grade1) {
        this.name = name;
        this.surname = surname;
        this.grade1 = grade1;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public float getGrade1() {
        return grade1;
    }

    public void setGrade1(float grade1) {
        this.grade1 = grade1;
    }
}
