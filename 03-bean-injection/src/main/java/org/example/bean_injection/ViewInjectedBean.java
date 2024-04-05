package org.example.bean_injection;

import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import org.example.beans.ApplicationBean;
import org.example.beans.DependentBean;
import org.example.beans.SessionBean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Named
@ViewScoped
public class ViewInjectedBean implements Serializable {
    private List<String> disciplines = Arrays.asList("ViewMath", "ViewBoiology", "ViewITOP");
    private List<String> selectedDisciplines = new ArrayList<>();
    private final SessionBean sessionBean;
    private final ApplicationBean applicationBean;
    private final DependentBean dependentBean;

    @Inject
    public ViewInjectedBean(DependentBean dependentBean, SessionBean sessionBean, ApplicationBean applicationBean) {
        this.sessionBean = sessionBean;
        this.applicationBean = applicationBean;
        this.dependentBean = dependentBean;
    }

    public void selectDiscipline() {
        int idx = ThreadLocalRandom.current().nextInt(disciplines.size());
        selectedDisciplines.add(disciplines.get(idx));
        sessionBean.selectDiscipline();
        applicationBean.selectDiscipline();
        dependentBean.selectDiscipline();
    }

    public DependentBean getDependentBean() {
        return dependentBean;
    }

    public ApplicationBean getApplicationBean() {
        return applicationBean;
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

    public SessionBean getSessionBean() {
        return sessionBean;
    }
}
