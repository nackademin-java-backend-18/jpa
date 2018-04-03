package se.coredev.extreme.repository.jpa;

import se.coredev.extreme.data.AbstractEntity;
import se.coredev.extreme.repository.CrudRepository;
import se.coredev.extreme.repository.RepositoryException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

public abstract class AbstractJpaRepository <E extends AbstractEntity> implements CrudRepository<E> {

    private final EntityManagerFactory factory;
    private final Class<E> entityClass;

    protected AbstractJpaRepository(EntityManagerFactory factory, Class<E> entityClass) {
        this.factory = factory;
        this.entityClass = entityClass;
    }

    @Override
    public E saveOrUpdate(E entity) {
        return entity.getId() == null ? execute(manager -> {
            manager.persist(entity);
            return entity;
        }) : execute(manager -> manager.merge(entity));
    }

    @Override
    public E remove(E entity) {
        return execute(manager -> {
            E entityToRemove = manager.find(entityClass, entity.getId());
            manager.remove(entityToRemove);
            return entityToRemove;
        });
    }

    @Override
    public E findById(Long id) {
        EntityManager manager = factory.createEntityManager();
        try {
            return manager.find(entityClass, id);
        } catch (PersistenceException e) {
            throw new RepositoryException(e);
        } finally {
            manager.close();
        }
    }

    @Override
    public List<E> findAll() {
        EntityManager manager = factory.createEntityManager();
        try {
            return manager.createQuery("FROM " + entityClass.getSimpleName(), entityClass).getResultList();
        } catch (PersistenceException e) {
            throw new RepositoryException(e);
        } finally {
            manager.close();
        }
    }

    protected void executeVoid(Consumer<EntityManager> operation) {
        EntityManager manager = factory.createEntityManager();
        try {
            manager.getTransaction().begin();
            operation.accept(manager);
            manager.getTransaction().commit();
        } catch (PersistenceException e) {
            manager.getTransaction().rollback();
            throw new RepositoryException(e);
        } finally {
            manager.close();
        }
    }

    protected E execute(Function<EntityManager, E> operation) {
        EntityManager manager = factory.createEntityManager();
        try {
            manager.getTransaction().begin();
            E result = operation.apply(manager);
            manager.getTransaction().commit();

            return result;
        } catch (PersistenceException e) {
            manager.getTransaction().rollback();
            throw new RepositoryException(e);
        } finally {
            manager.close();
        }
    }

    protected List<E> query(String queryName, Function<TypedQuery<E>, TypedQuery<E>> query) {
        EntityManager manager = factory.createEntityManager();
        try {
            TypedQuery<E> typedQuery = manager.createNamedQuery(queryName, entityClass);
            return query.apply(typedQuery).getResultList();
        } catch (PersistenceException e) {
            throw new RepositoryException(e);
        } finally {
            manager.close();
        }
    }

    protected E querySingle(String queryName, Function<TypedQuery<E>, TypedQuery<E>> query) {
        return query(queryName, query).get(0);
    }
}
