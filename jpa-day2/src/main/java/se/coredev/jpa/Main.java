package se.coredev.jpa;

import se.coredev.jpa.data.Address;
import se.coredev.jpa.data.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public final class Main {

    private static final EntityManagerFactory factory = Persistence.createEntityManagerFactory("PersistenceUnit");

    public static void main(String[] args) {

        EntityManager manager = factory.createEntityManager();

        Address address = manager.find(Address.class, 2L);
        System.out.println(address.getUsers().size());

//        manager.getTransaction().begin();
//        Address address = new Address("street", "postal", "zip");
//        User user = new User("master", address);
//        manager.persist(user);
//        manager.persist(address);
//        manager.getTransaction().commit();
    }

}
