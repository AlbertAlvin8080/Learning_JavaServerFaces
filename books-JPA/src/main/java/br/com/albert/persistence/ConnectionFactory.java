package br.com.albert.persistence;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.hibernate.jpa.HibernatePersistenceProvider;

import java.util.HashMap;
import java.util.Map;

public class ConnectionFactory {
//    private static final EntityManagerFactory emt = Persistence.createEntityManagerFactory("meuPU");
    private static final Map<String, Object> properties;
    private static final EntityManagerFactory emt;

    static {
        properties = new HashMap<>();
        properties.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
        properties.put("hibernate.show_sql", "true");
        properties.put("hibernate.format_sql", "true");
        properties.put("hibernate.hbm2ddl.auto", "update"); // update, create, none
        emt = new HibernatePersistenceProvider()
                .createContainerEntityManagerFactory(new CustomPersistenceUnitInfo(), properties);
    }

    public static EntityManager getConnection() {
        return emt.createEntityManager();
    }
}