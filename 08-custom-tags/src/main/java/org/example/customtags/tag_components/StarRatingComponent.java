package org.example.customtags.tag_components;

import jakarta.faces.component.FacesComponent;
import jakarta.faces.component.UIComponentBase;
import jakarta.faces.context.FacesContext;
import jakarta.faces.context.ResponseWriter;

import java.io.IOException;

@FacesComponent(value = "starRating")
public class StarRatingComponent extends UIComponentBase {
    private int maxRating;
    private int rating;

    public int getMaxRating() {
        return maxRating;
    }

    public void setMaxRating(int maxRating) {
        this.maxRating = maxRating;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    @Override
    public boolean getRendersChildren() {
        return true;
    }

    @Override
    public String getFamily() {
        return "rating";
    }

    @Override
    public void encodeBegin(FacesContext context) throws IOException {
        ResponseWriter writer = context.getResponseWriter();
        writer.startElement("div", null);
        for (int i = 0; i < maxRating; ++i) {
            String styleClass = i <= rating ? "rating rating-full" : "rating";
            writer.startElement("span", null);
            writer.writeAttribute("class", styleClass, null);
            writer.endElement("span");
        }
        writer.endElement("div");
        writer.close();
    }
}
