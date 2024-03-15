package org.example.customtags.tag_handlers;

import jakarta.faces.component.UIComponent;
import jakarta.faces.component.UIOutput;
import jakarta.faces.component.html.HtmlOutputLabel;
import jakarta.faces.view.facelets.FaceletContext;
import jakarta.faces.view.facelets.TagAttribute;
import jakarta.faces.view.facelets.TagConfig;
import jakarta.faces.view.facelets.TagHandler;

import java.io.IOException;
import java.util.Objects;

public class TextRepeatHandler extends TagHandler {
    private TagAttribute text;
    private TagAttribute repeat;
    private TagAttribute uppercase;

    public TextRepeatHandler(TagConfig config) {
        super(config);
        text = this.getRequiredAttribute("text");
        repeat = this.getRequiredAttribute("repeat");
        uppercase = this.getAttribute("uppercase");
    }

    @Override
    public void apply(FaceletContext faceletContext, UIComponent uiComponent) throws IOException {
        boolean up;
        if(Objects.nonNull(uppercase)) {
            up = uppercase.getBoolean(faceletContext);
        } else {
            up = false;
        }

        String txt = up ? text.getValue().toUpperCase() : text.getValue();

        for(int i = 0; i < repeat.getInt(faceletContext); ++i) {
            UIOutput child = new HtmlOutputLabel();
            child.setValue(txt);
            uiComponent.getChildren().add(child);
        }
    }
}
