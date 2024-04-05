package bean.escopes_test;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Named
@SessionScoped
public class ListSessionScoped implements Serializable {
    private List<String> list = Arrays.asList("Boogiepop", "Klaus Poppe", "Franz Bonaparta");
    private List<String> listSelected = new ArrayList<>();

    @PostConstruct
    private void init() {
        System.out.println("Inside post construct: Session Scoped");
    }

    public void selectItem() {
        int idx = ThreadLocalRandom.current().nextInt(3);
        listSelected.add(list.get(idx));
    }

    public String logout() {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "sessionScoped.xhtml?faces-redirect=true";
    }

    public List<String> getListSelected() {
        return listSelected;
    }
}
