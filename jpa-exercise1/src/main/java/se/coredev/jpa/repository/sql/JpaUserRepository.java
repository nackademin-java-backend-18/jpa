package se.coredev.jpa.repository.sql;

import se.coredev.jpa.data.User;
import se.coredev.jpa.repository.UserRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

final class JpaUserRepository implements UserRepository {

    private final  EntityManagerFactory factory;

    public JpaUserRepository(EntityManagerFactory factory) {
        this.factory = factory;
    }

    @Override
    public User addUser(User user) {

        EntityManager manager = factory.createEntityManager();
        manager.getTransaction().begin();
        manager.persist(user);
        manager.getTransaction().commit();

        return user;
    }

    @Override
    public User updateUser(User user) {
        return null;
    }

    @Override
    public User getUser(Long id) {
        return factory.createEntityManager().find(User.class, id);
    }

    @Override
    public List<User> getAllUsers() {
        return factory.createEntityManager().createQuery("from User u").getResultList();
    }
}
