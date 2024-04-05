package bean.escopes_test;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Named
@RequestScoped
public class ListRequestScoped implements Serializable {
    private List<String> list = Arrays.asList("Boogiepop", "Klaus Poppe", "Franz Bonaparta");
    private List<String> listSelected = new ArrayList<>();

    @PostConstruct
    private void init() {
        System.out.println("Inside post construct: Request Scoped");
    }

    public void selectItem() {
        int idx = ThreadLocalRandom.current().nextInt(3);
        listSelected.add(list.get(idx));
    }

    public List<String> getListSelected() {
        return listSelected;
    }
}
