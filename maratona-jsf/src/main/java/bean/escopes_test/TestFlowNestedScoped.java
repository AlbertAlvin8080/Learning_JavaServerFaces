package bean.escopes_test;

import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.flow.FlowScoped;
import jakarta.inject.Named;

import javax.print.attribute.standard.Severity;
import java.io.Serializable;

@Named
@FlowScoped(value = "pendencies")
public class TestFlowNestedScoped implements Serializable {
    private String name;
    private String surname;

    public String validate() {
        System.out.println("Validando dados...");
        if (true) {
            FacesContext instance = FacesContext.getCurrentInstance();
            instance.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "User did not pass in validation", "More Details"));
            instance.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "Maybe your name is too long", "More details"));
            return null;
        }
        return "continueRegistration";
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
}
