package br.com.albert.bean;

import br.com.albert.dao.BookDAO;
import br.com.albert.entity.Book;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import org.primefaces.PrimeFaces;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Named
@ViewScoped
//@SessionScoped
public class bookBean implements Serializable {
    private Book newBook;
    private Set<Book> bookSet;
    private final BookDAO dao = new BookDAO();

    @PostConstruct
    public void init() {
        newBook = new Book();
    }

    public String goToEdit(Book book) {
        FacesContext.getCurrentInstance().getExternalContext().getFlash().put("book", book);
        return "/bookEdit?faces-redirect=true";
    }

    public void add() {
        dao.persist(newBook);
        PrimeFaces.current().executeScript("PF('dialogAddBook').hide();");

        FacesMessage msg = new FacesMessage("Book Added", newBook.getName());
        FacesContext.getCurrentInstance().addMessage(null, msg);

        newBook = new Book();
        loadBooks();
    }

    public void remove(Book book) {
        if (dao.remove(book)) {
            bookSet.remove(book);
        } else {
            FacesContext
                    .getCurrentInstance()
                    .addMessage(null,
                            new FacesMessage(
                                    FacesMessage.SEVERITY_ERROR, "error removing book", ""));
        }
    }

    public void loadBooks() {
        bookSet = new HashSet<>(dao.findAll());
    }

    public Book getNewBook() {
        return newBook;
    }

    public void setNewBook(Book newBook) {
        this.newBook = newBook;
    }

    public Set<Book> getBookSet() {
        return bookSet;
    }

    public void setBookSet(Set<Book> bookSet) {
        this.bookSet = bookSet;
    }
}
