package br.com.albert.dao;

import br.com.albert.entity.Author;
import br.com.albert.persistence.ConnectionFactory;
import jakarta.persistence.EntityManager;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class AuthorDAO {
    public Set<Author> findByName(List<String> namesList) {
        EntityManager em = ConnectionFactory.getConnection();
        Set<Author> resultSet = new HashSet<>();

        try {
            em.getTransaction().begin();

            List<Author> authors = em.createQuery("select a from Author a where a.name in :names", Author.class)
                    .setParameter("names", namesList)
                    .getResultList();

            Map<String, Author> authorMap = authors.stream()
                    .collect(Collectors.toMap(Author::getName, Function.identity()));

            for (String name : namesList)
                resultSet.add(authorMap.getOrDefault(name, new Author(name)));

            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }

        return resultSet;
    }
}
