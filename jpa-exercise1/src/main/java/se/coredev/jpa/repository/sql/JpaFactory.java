package se.coredev.jpa.repository.sql;

import se.coredev.jpa.repository.UserRepository;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public final class JpaFactory {

    private static final EntityManagerFactory factory = Persistence.createEntityManagerFactory("PersistenceUnit");

    private JpaFactory(){}

    public static UserRepository createUserRepository() {
        return new JpaUserRepository(factory);
    }

}
