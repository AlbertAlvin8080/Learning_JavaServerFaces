package br.com.albert.dao;

import br.com.albert.entity.Book;
import br.com.albert.persistence.ConnectionFactory;
import jakarta.persistence.EntityGraph;
import jakarta.persistence.EntityManager;

import java.util.List;

public class BookDAO {
    public List<Book> findAll() {
        EntityManager em = ConnectionFactory.getConnection();
        List<Book> list = null;

        try {
            em.getTransaction().begin();

            EntityGraph<Book> graph = em.createEntityGraph(Book.class);
            graph.addAttributeNodes("authorSet");
            graph.addAttributeNodes("storeSet");

            list = em.createQuery("select b from Book b", Book.class)
                    .setHint("jakarta.persistence.loadgraph", graph)
                    .getResultList();

            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }

        return list;
    }

    public boolean remove(Book book) {
        EntityManager em = ConnectionFactory.getConnection();
        try {
            em.getTransaction().begin();
            em.createQuery("delete from Book b where b.id = :id")
                    .setParameter("id", book.getId())
                    .executeUpdate();
            em.getTransaction().commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
        return false;
    }

    public boolean persist(Book book) {
        EntityManager em = ConnectionFactory.getConnection();
        try {
            em.getTransaction().begin();
            em.persist(book);
            em.getTransaction().commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
        return false;
    }

    public boolean update(Book book) {
        EntityManager em = ConnectionFactory.getConnection();

        try {
            em.getTransaction().begin();
            em.merge(book);
            em.getTransaction().commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }

        return false;
    }
}
