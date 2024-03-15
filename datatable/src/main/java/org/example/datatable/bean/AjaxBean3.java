package org.example.datatable.bean;

import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
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
public class AjaxBean3 implements Serializable {
    private Map<String, List<String>> animes = new HashMap<>();
    private List<String> characters;
    private String anime;
    private String character;

    {
        animes.put("Kiseujuu", Arrays.asList("Migi", "Gotou"));
        animes.put("Mushoku Tensei", Arrays.asList("Rudeus", "Eris", "Ghislaine"));
        animes.put("Jujutsu Kaisen", Arrays.asList("Mahito", "Getou", "Jogo"));
        animes.put("Monster", Arrays.asList("Klaus Poppe", "Johan", "Lunge"));
    }

    public void chooseAnime() {
        if (anime == null) {
            characters = null;
        } else {
            characters = animes.get(anime);
        }
    }

    public void chooseCharacter() {
        String summary, detail;
        FacesMessage.Severity severity;

        if (character == null || anime == null) {
            severity = FacesMessage.SEVERITY_ERROR;
            summary = "What?";
            detail = "How is it null?";
        } else {
            severity = FacesMessage.SEVERITY_INFO;
            summary = character;
            detail = anime;
        }

        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(severity, summary, detail));
    }

    public Map<String, List<String>> getAnimes() {
        return animes;
    }

    public void setAnimes(Map<String, List<String>> animes) {
        this.animes = animes;
    }

    public List<String> getCharacters() {
        return characters;
    }

    public void setCharacters(List<String> characters) {
        this.characters = characters;
    }

    public String getAnime() {
        return anime;
    }

    public void setAnime(String anime) {
        this.anime = anime;
    }

    public String getCharacter() {
        return character;
    }

    public void setCharacter(String character) {
        this.character = character;
    }
}
