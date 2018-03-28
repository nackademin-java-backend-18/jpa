package se.coredev.jpa;


import se.coredev.jpa.data.Role;
import se.coredev.jpa.data.User;

import javax.persistence.EntityGraph;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Root;
import java.util.Collections;
import java.util.List;

public final class Main {

    private static final EntityManagerFactory factory = Persistence.createEntityManagerFactory("PersistenceUnit");

    public static void main(String[] args) {

        Role role = new Role("Admin");
        User user1 = new User("luke", role);
        User user2 = new User("leia", role);

        EntityManager manager = factory.createEntityManager();
        manager.getTransaction().begin();
        manager.persist(role);
        manager.persist(user1);
        manager.persist(user2);
        manager.getTransaction().commit();
        manager.close();

        manager = factory.createEntityManager();
        manager.createNamedQuery("User.getByUsername", User.class)
                .setParameter("username", "leia")
                .getResultList()
                .forEach(System.out::println);

        List<Role> roles = manager.createQuery("SELECT DISTINCT r FROM Role r JOIN FETCH r.users", Role.class).getResultList();
        roles.forEach(r -> r.getUsers().forEach(System.out::println));
    }
}

/*
EntityGraph graph = this.em.createEntityGraph(Order.class);
Subgraph itemGraph = graph.addSubgraph("items");

Map hints = new HashMap();
hints.put("javax.persistence.loadgraph", graph);

Order order = this.em.find(Order.class, orderId, hints);
 */
