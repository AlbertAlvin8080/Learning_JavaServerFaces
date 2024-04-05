package bean.escopes_test;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.Conversation;
import jakarta.enterprise.context.ConversationScoped;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Named
@ConversationScoped
public class ListConversationScoped implements Serializable {
    private List<String> list = Arrays.asList("Boogiepop", "Klaus Poppe", "Franz Bonaparta");
    private List<String> listSelected = new ArrayList<>();
    @Inject
    private Conversation conversartion;

    public Conversation getConversartion() {
        return conversartion;
    }

    public void init() {
        System.out.println("Inside post construct: Conversation Scoped");
        if(conversartion.isTransient()) {
            conversartion.begin();
            System.out.println("Long Running: START");
        }
    }

    public String end() {
        if(!conversartion.isTransient()) {
            conversartion.end();
            System.out.println("Return to Transient: END");
        }
        return "conversationScoped?facet-redirect=true";
    }

    public void selectItem() {
        int idx = ThreadLocalRandom.current().nextInt(3);
        listSelected.add(list.get(idx));
    }

    public List<String> getListSelected() {
        return listSelected;
    }
}
