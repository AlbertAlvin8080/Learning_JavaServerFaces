package org.example.datatable.converter;

import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.FacesConverter;
import org.example.datatable.student.Student;

@FacesConverter(value = "studentConverter")
public class StudentConverter implements Converter {
    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String s) {
        if (s == null || !s.matches("\\d+"))
            return null;
        return uiComponent.getAttributes().get(s);
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object o) {
        if(o != null) {
            Student s = (Student) o;
            Integer id = s.getId();
            if(id != null) {
                uiComponent.getAttributes().put(id.toString(), o);
                return id.toString();
            }
        }
        return null;
    }
}
