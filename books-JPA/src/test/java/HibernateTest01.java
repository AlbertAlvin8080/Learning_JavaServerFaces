import br.com.albert.entity.Book;
import br.com.albert.persistence.ConnectionFactory;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

public class HibernateTest01 {
    public static void main(String[] args) {
        EntityManager em = ConnectionFactory.getConnection();
        em.getTransaction().begin();
        TypedQuery<Book> query = em.createQuery("select b from Book b", Book.class);
        query.getResultList().forEach(b -> {
            System.out.println(b);
            System.out.println(b.getStoreSet());
        });
        em.getTransaction().commit();
        em.close();
    }
}
