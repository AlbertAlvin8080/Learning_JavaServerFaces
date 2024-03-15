package org.example.beans;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Named;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Named
@Dependent
public class DependentBean implements Serializable {
    private List<String> disciplines = Arrays.asList("Math", "Boiology", "I. To Progr.");
    private List<String> selectedDisciplines = new ArrayList<>();

    public void selectDiscipline() {
        int idx = ThreadLocalRandom.current().nextInt(disciplines.size());
        selectedDisciplines.add(disciplines.get(idx));
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
