package org.example.datatable.bean;

import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;

import java.io.Serializable;

@Named
@SessionScoped
public class StaticResourcesBean implements Serializable {
    private String name;
    private boolean bSeAdapta;
    private int nullCount;

    public void save() {
//  needs jakarta.faces.INTERPRET_EMPTY_STRING_SUBMITTED_VALUES_AS_NULL = true
        if (name == null) {
            nullCount++;
            bSeAdapta = false;
        } else {
            nullCount = 0;
            bSeAdapta = true;
        }
        System.out.println(name);
    }

    public boolean seAdaptaLegalmente() {
        return nullCount > 3;
    }

    public boolean isbSeAdapta() {
        return bSeAdapta;
    }

    public void setbSeAdapta(boolean bSeAdapta) {
        this.bSeAdapta = bSeAdapta;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
