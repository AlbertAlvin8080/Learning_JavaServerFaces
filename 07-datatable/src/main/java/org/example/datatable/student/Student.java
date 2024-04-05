package org.example.datatable.student;

import org.example.datatable.student.enums.Turno;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Student implements Serializable {
    public Student(String name, String email, float grade) {
        this.name = name;
        this.email = email;
        this.grade1 = grade;
    }

    public static List<Student> studentList() {
        return new ArrayList<>(
                Arrays.asList(
                        new Student("Klaus", "Poppe", "klaus@gmail.com", 10f),
                        new Student("Johan", "Libert", "libert@gmail.com", 4f),
                        new Student("Guts", "", "gutsss@hotmail.com", 1.5f),
                        new Student("Reiner", "Brown", "armored@gmail.com", 8.9f),
                        new Student("Alberto", "Fernandez", "kaibutsu@gmail.com", 9.2f),
                        new Student("Erasmus", "Darwin", "kaibutsu@gmail.com", 9.2f),
                        new Student("Charles", "Darwin", "kaibutsu@gmail.com", 9.2f),
                        new Student("Ghislaine", "Dedoldia", "kaibutsu@gmail.com", 9.2f),
                        new Student("Eve", "Nechwastein", "kaibutsu@gmail.com", 9.2f)
                )
        );
    }

    private static int idCount;
    private static int provideID() {
        return ++idCount;
    }

    private Integer id;
    private String name;
    private String surname;
    private String email;
    private Float grade1;
    private Turno turno;
    private transient boolean editing;

    public void edit() {
        editing = true;
    }

    public void endEdit() {
        editing = false;
    }

    public Turno getTurno() {
        return turno;
    }

    public void setTurno(Turno turno) {
        this.turno = turno;
    }

    public boolean isEditing() {
        return editing;
    }

    public void setEditing(boolean editing) {
        this.editing = editing;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", grade1=" + grade1 +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(id, student.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public Student(String name, String surname, String email, Float grade1) {
        this();
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.grade1 = grade1;
    }

    public Student() {
        this.id = provideID();
//        System.out.println(id);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Float getGrade1() {
        return grade1;
    }

    public void setGrade1(Float grade1) {
        this.grade1 = grade1;
    }
}
