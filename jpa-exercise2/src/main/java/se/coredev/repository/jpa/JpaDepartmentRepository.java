package se.coredev.repository.jpa;

import se.coredev.data.Department;
import se.coredev.repository.DepartmentRepository;
import se.coredev.repository.RepositoryException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceException;

final class JpaDepartmentRepository implements DepartmentRepository {

    private final EntityManagerFactory factory;

    public JpaDepartmentRepository(EntityManagerFactory factory) {
        this.factory = factory;
    }

    @Override
    public Department addDepartment(Department department) {
        EntityManager manager = factory.createEntityManager();

        try {
            manager.getTransaction().begin();
            manager.persist(department);
            manager.getTransaction().commit();

            return department;
        } catch (PersistenceException e) {
            manager.getTransaction().rollback();
            throw new RepositoryException("Could not add departent: " + department, e);
        } finally {
            manager.close();
        }
    }

    @Override
    public Department getDepartmentById(Long id) {
        EntityManager manager = factory.createEntityManager();
        try {
            return manager.find(Department.class, id);
        } catch (PersistenceException e) {
            throw new RepositoryException("Could not get department with id:" + id, e);
        } finally {
            manager.close();
        }
    }
}
