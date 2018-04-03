package se.coredev.extreme.repository.jpa;

import se.coredev.extreme.data.Department;
import se.coredev.extreme.repository.DepartmentRepository;

import javax.persistence.EntityManagerFactory;

public final class JpaDepartmentRepository extends AbstractJpaRepository<Department> implements DepartmentRepository {

    public JpaDepartmentRepository(EntityManagerFactory factory) {
        super(factory, Department.class);
    }
}
