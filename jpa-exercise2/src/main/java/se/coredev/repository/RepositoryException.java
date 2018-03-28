package se.coredev.repository;

import javax.persistence.PersistenceException;

public class RepositoryException extends RuntimeException {

    public RepositoryException(String message, PersistenceException cause) {
        super(message, cause);
    }
}
