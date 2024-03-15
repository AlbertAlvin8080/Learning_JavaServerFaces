package org.example.datatable.bean;

import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import org.example.datatable.student.Student;

import java.io.Serializable;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Named
@ViewScoped
public class AjaxBean implements Serializable {
    private Student student = new Student();
    private Map<String, List<String>> animes = new HashMap<>();
    private String anime;
    private String character;
    private List<String> characters;

    public void init()
    {
        animes.put("Hellsing", Arrays.asList("Alucard", "Andersen", "Seras"));
        animes.put("Vinland Saga", Arrays.asList("Thorgil", "Askellad", "Thorfin"));
        animes.put("Berserk", Arrays.asList("Guts", "Griffith", "Casca"));
    }

    public void toUpperCase() {
        student.setName(student.getName().toUpperCase());
        student.setSurname(student.getSurname().toUpperCase());
    }

    public void toUpperCase2() {
        student.setName(student.getName().toUpperCase());
    }

    public void selectCharacters() {
        if(anime == null) {
            characters = null;
        } else {
            characters = animes.get(anime);
        }
    }

    public String getCharacter() {
        return character;
    }

    public void setCharacter(String character) {
        this.character = character;
    }

    public String getAnime() {
        return anime;
    }

    public void setAnime(String anime) {
        this.anime = anime;
    }

    public List<String> getCharacters() {
        return characters;
    }

    public void setCharacters(List<String> characters) {
        this.characters = characters;
    }

    public Map<String, List<String>> getAnimes() {
        return animes;
    }

    public void setAnimes(Map<String, List<String>> animes) {
        this.animes = animes;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
