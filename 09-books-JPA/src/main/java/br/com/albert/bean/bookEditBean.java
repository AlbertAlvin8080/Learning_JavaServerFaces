package br.com.albert.bean;

import br.com.albert.dao.AuthorDAO;
import br.com.albert.dao.BookDAO;
import br.com.albert.entity.Author;
import br.com.albert.entity.Book;
import jakarta.annotation.PostConstruct;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Named
@ViewScoped
public class bookEditBean implements Serializable {
    @NotNull
    private String authorsNames;
    private Book book = new Book();
    private final BookDAO bookDAO = new BookDAO();
    private final AuthorDAO authorDAO = new AuthorDAO();

    @PostConstruct
    public void init() {
        book = (Book) FacesContext.getCurrentInstance().getExternalContext().getFlash().get("book");
        authorsNames = book.getAuthorSet().stream().map(Author::getName).collect(Collectors.joining(", "));
    }

    public String save() {
        List<String> collect = Arrays.stream(authorsNames.split(",")).map(String::trim).toList();

        Set<Author> authors = null;
        if (!authorsNames.isEmpty())
            authors = authorDAO.findByName(collect);

        book.setAuthorSet(authors);
        bookDAO.update(book);

        return "/index?faces-redirect=true";
//        return "/index?faces-redirect=true&shouldFetch=true";
    }

    public String getAuthorsNames() {
        return authorsNames;
    }

    public void setAuthorsNames(String authorsNames) {
        this.authorsNames = authorsNames;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
