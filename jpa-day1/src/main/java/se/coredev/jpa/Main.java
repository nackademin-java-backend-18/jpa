package se.coredev.jpa;


import se.coredev.jpa.data.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public final class Main {

    private static final EntityManagerFactory factory = Persistence.createEntityManagerFactory("PersistenceUnit");

    public static void main(String[] args) {
        EntityManager manager = factory.createEntityManager();
        Employee employee = new Employee("Luke", "Skywalker");

        System.out.println("Before - " + employee);

        manager.getTransaction().begin();
        manager.persist(employee);
        manager.getTransaction().commit();

        System.out.println("After - " + employee);
    }

}
