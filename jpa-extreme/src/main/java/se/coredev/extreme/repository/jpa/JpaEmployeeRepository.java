package se.coredev.extreme.repository.jpa;

import se.coredev.extreme.data.Employee;
import se.coredev.extreme.repository.EmployeeRepository;

import javax.persistence.EntityManagerFactory;

public class JpaEmployeeRepository extends AbstractJpaRepository<Employee> implements EmployeeRepository {

    public JpaEmployeeRepository(EntityManagerFactory factory) {
        super(factory, Employee.class);
    }

    @Override
    public Employee getByEmployeeNumber(String number) {
        return querySingle("Employee.GetByEmployeeNumber", q -> q.setParameter("number", number));
    }
}
