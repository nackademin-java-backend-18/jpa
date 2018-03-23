package se.coredev.jpa;

import se.coredev.jpa.data.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public final class Main {

    private static final EntityManagerFactory factory = Persistence.createEntityManagerFactory("PersistenceUnit");

    public static void main(String[] args) {

        User user = new User("Luke", "Skywalker");

        EntityManager manager = factory.createEntityManager();
        manager.getTransaction().begin();
        manager.persist(user);
        manager.getTransaction().commit();

        System.out.println(user);
    }

}
