package se.coredev.repository.jpa;

import se.coredev.data.Employee;
import se.coredev.repository.EmployeeRepository;
import se.coredev.repository.RepositoryException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceException;

final class JpaEmployeeRepository implements EmployeeRepository {

    private final EntityManagerFactory factory;

    JpaEmployeeRepository(EntityManagerFactory factory) {
        this.factory = factory;
    }

    @Override
    public Employee addEmployee(Employee employee) {
        EntityManager manager = factory.createEntityManager();

        try {
            manager.getTransaction().begin();
            manager.persist(employee);
            manager.getTransaction().commit();

            return employee;
        } catch (PersistenceException e) {
            manager.getTransaction().rollback();
            throw new RepositoryException("Could not add employee: " + employee, e);
        } finally {
            manager.close();
        }
    }
}
