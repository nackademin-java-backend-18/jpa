package se.coredev.jpa;


import se.coredev.jpa.data.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public final class Main {

    private static final EntityManagerFactory factory = Persistence.createEntityManagerFactory("PersistenceUnit");

    public static void main(String[] args) {

        EntityManager manager = factory.createEntityManager();
        manager.createNamedQuery("User.getByUsername", User.class)
                .setParameter("username", "leia")
                .getResultList()
                .forEach(System.out::println);

        manager.close();

    }
}
