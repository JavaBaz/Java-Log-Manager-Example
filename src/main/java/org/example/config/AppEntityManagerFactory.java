package org.example.config;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class AppEntityManagerFactory {

    private static final EntityManagerFactory entityManagerFactory ;

    static {
        entityManagerFactory =  Persistence.createEntityManagerFactory("postgres");
    }


    private AppEntityManagerFactory() {
    }

    public static EntityManagerFactory getEntityManagerFactory() {
        return  entityManagerFactory;
    }
}
