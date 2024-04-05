package org.example.customtags.tag_handlers;

import jakarta.faces.component.UIComponent;
import jakarta.faces.component.html.HtmlInputText;
import jakarta.faces.view.facelets.FaceletContext;
import jakarta.faces.view.facelets.TagConfig;
import jakarta.faces.view.facelets.TagHandler;

import java.io.IOException;
import java.io.InvalidClassException;

public class InputTextStyleHandler extends TagHandler {
    public InputTextStyleHandler(TagConfig config) {
        super(config);
    }

    @Override
    public void apply(FaceletContext faceletContext, UIComponent uiComponent) throws IOException {
        if (uiComponent instanceof HtmlInputText) {
            HtmlInputText input = (HtmlInputText) uiComponent;
            String styleClass = input.getStyleClass();
            if (styleClass == null || styleClass.isEmpty()) {
                input.setStyleClass("input-style");
            } else {
                // styleClass.isEmpty() == false
                input.setStyleClass(styleClass + " input-style");
            }
        } else {
            throw new InvalidClassException("The parent must be an instance of HtmlInputText");
        }
    }
}
