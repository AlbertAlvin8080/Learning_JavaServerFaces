package org.example.communication.beans;

import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import org.omnifaces.util.Faces;

import java.io.Serializable;

@Named
@ViewScoped
public class CommunicationBean10 implements Serializable {
    private String key;
    private String value;

    public void init() {
        value = Faces.getRequestCookie(key);
    }

    public void showCookie() {
        System.out.println(Faces.getRequestCookie(key) + " ["+key+"]:[" + value + "]" );
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
