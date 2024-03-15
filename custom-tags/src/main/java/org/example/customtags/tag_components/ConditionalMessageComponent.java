package org.example.customtags.tag_components;

import jakarta.faces.component.FacesComponent;
import jakarta.faces.component.UIComponentBase;
import jakarta.faces.context.FacesContext;
import jakarta.faces.context.ResponseWriter;

import java.io.IOException;

@FacesComponent(value = "conditionalMessage")
public class ConditionalMessageComponent extends UIComponentBase {
    private String trueMessage;
    private String falseMessage;
    private boolean condition;

    public String getTrueMessage() {
        return trueMessage;
    }

    public void setTrueMessage(String trueMessage) {
        this.trueMessage = trueMessage;
    }

    public String getFalseMessage() {
        return falseMessage;
    }

    public void setFalseMessage(String falseMessage) {
        this.falseMessage = falseMessage;
    }

    public boolean isCondition() {
        return condition;
    }

    public void setCondition(boolean condition) {
        this.condition = condition;
    }

    @Override
    public String getFamily() {
        return "conditional";
    }

    @Override
    public boolean getRendersChildren() {
        return true;
    }

    @Override
    public void encodeBegin(FacesContext context) throws IOException {
        ResponseWriter writer = context.getResponseWriter();
        writer.startElement("div", null);
        writer.writeAttribute("style", "color: " + (condition ? "blue" : "red") + ";", null);
        writer.writeText(condition ? trueMessage : falseMessage, null);
        writer.endElement("div");
    }
}
