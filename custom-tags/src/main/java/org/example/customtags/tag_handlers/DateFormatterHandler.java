package org.example.customtags.tag_handlers;

import jakarta.faces.component.UIComponent;
import jakarta.faces.component.html.HtmlOutputText;
import jakarta.faces.view.facelets.FaceletContext;
import jakarta.faces.view.facelets.TagAttribute;
import jakarta.faces.view.facelets.TagConfig;
import jakarta.faces.view.facelets.TagHandler;

import java.io.IOException;
import java.text.SimpleDateFormat;

public class DateFormatterHandler extends TagHandler {
    private TagAttribute date;
    private TagAttribute pattern;

    public DateFormatterHandler(TagConfig config) {
        super(config);
        date = this.getRequiredAttribute("date");
        pattern = this.getRequiredAttribute("pattern");
    }

    @Override
    public void apply(FaceletContext faceletContext, UIComponent uiComponent) throws IOException {
        String formatted = new SimpleDateFormat(pattern.getValue()).format(date.getObject(faceletContext));
        HtmlOutputText htmlOutputText = new HtmlOutputText();
        htmlOutputText.setValue(formatted);
        uiComponent.getChildren().add(htmlOutputText);
    }
}
