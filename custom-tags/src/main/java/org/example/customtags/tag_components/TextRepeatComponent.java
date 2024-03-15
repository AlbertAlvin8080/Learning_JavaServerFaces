package org.example.customtags.tag_components;

import jakarta.faces.component.FacesComponent;
import jakarta.faces.component.UIComponentBase;
import jakarta.faces.context.FacesContext;
import jakarta.faces.context.ResponseWriter;

import java.io.IOException;

@FacesComponent(value = "textRepeat")
public class TextRepeatComponent extends UIComponentBase {
    private String text;
    private int repeat;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getRepeat() {
        return repeat;
    }

    public void setRepeat(int repeat) {
        this.repeat = repeat;
    }

    @Override
    public String getFamily() {
        return "Text";
    }

    @Override
    public boolean getRendersChildren() {
        return true;
    }

    @Override
    public void encodeBegin(FacesContext context) throws IOException {
        ResponseWriter writer = context.getResponseWriter();
        for (int i = 0; i < repeat; ++i) {
            writer.startElement("div", null);
            writer.writeText(text, null);
            writer.endElement("div");
        }
        writer.close();
    }
}
