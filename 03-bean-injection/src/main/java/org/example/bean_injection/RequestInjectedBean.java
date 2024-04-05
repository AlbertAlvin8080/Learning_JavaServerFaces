package org.example.bean_injection;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import org.example.beans.ApplicationBean;
import org.example.beans.DependentBean;
import org.example.beans.SessionBean;
import org.example.beans.ViewBean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Named
@RequestScoped
public class RequestInjectedBean implements Serializable {
    private List<String> disciplines = Arrays.asList("ViewMath", "ViewBoiology", "ViewITOP");
    private List<String> selectedDisciplines = new ArrayList<>();

    private final ApplicationBean applicationBean;
    private final SessionBean sessionBean;
    private final ViewBean viewBean;
    private final DependentBean dependentBean;

    @Inject
    public RequestInjectedBean(DependentBean dependentBean, ViewBean viewBean, SessionBean sessionBean, ApplicationBean applicationBean) {
        this.viewBean = viewBean;
        this.sessionBean = sessionBean;
        this.applicationBean = applicationBean;
        this.dependentBean = dependentBean;
    }

    public void selectDiscipline() {
        int idx = ThreadLocalRandom.current().nextInt(disciplines.size());
        selectedDisciplines.add(disciplines.get(idx));
        applicationBean.selectDiscipline();
        sessionBean.selectDiscipline();
        viewBean.selectDiscipline();
        dependentBean.selectDiscipline();
    }

    public ViewBean getViewBean() {
        return viewBean;
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
