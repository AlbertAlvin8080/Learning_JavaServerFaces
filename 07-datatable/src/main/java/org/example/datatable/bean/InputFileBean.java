package org.example.datatable.bean;

import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import jakarta.servlet.http.Part;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Path;

@Named
@ViewScoped
public class InputFileBean implements Serializable {
    private Part filePart;

    public void upload() {
        if (filePart == null) return;
        try (InputStream is = filePart.getInputStream()) {
            System.out.println(filePart.getSubmittedFileName());
            System.out.println(filePart.getSize());
            System.out.println(filePart.getName());
            System.out.println(filePart.getHeaderNames());
            System.out.println(filePart.getHeader("Content-Disposition"));
            System.out.println(filePart.getHeader("Content-Type"));
            System.out.println(filePart.getContentType());

            String location = FacesContext.getCurrentInstance().getExternalContext().getInitParameter("files.location");
            String originalFileName = filePart.getSubmittedFileName();
            String nameWithoutExtension = originalFileName.substring(0, originalFileName.lastIndexOf("."));
            String extension = originalFileName.substring(originalFileName.lastIndexOf("."));
            Path path = new File(location, originalFileName).toPath();

            StringBuilder sb = new StringBuilder(nameWithoutExtension);
            for (int i = 1; Files.exists(path); ++i) {
                sb.append("(").append(i).append(")").append(extension);
                path = new File(location, sb.toString()).toPath();
                // Reset StringBuilder for the next iteration
                sb.setLength(nameWithoutExtension.length());
            }
            Files.copy(is, path);

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("File Saved", originalFileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Part getFilePart() {
        return filePart;
    }

    public void setFilePart(Part filePart) {
        this.filePart = filePart;
    }
}
