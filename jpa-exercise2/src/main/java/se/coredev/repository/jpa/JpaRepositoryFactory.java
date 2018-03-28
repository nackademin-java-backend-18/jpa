package se.coredev.repository.jpa;

import se.coredev.repository.DepartmentRepository;
import se.coredev.repository.EmployeeRepository;
import se.coredev.repository.ParkingSpotRepository;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public final class JpaRepositoryFactory {

    private static final EntityManagerFactory factory = Persistence.createEntityManagerFactory("PersistenceUnit");

    private JpaRepositoryFactory() {
    }

    public static DepartmentRepository createDepartmentRepository() {
        return new JpaDepartmentRepository(factory);
    }

    public static EmployeeRepository createEmployeeRepository() {
        return new JpaEmployeeRepository(factory);
    }

    public static ParkingSpotRepository createParkingSpotRepository() {
        return new JpaParkingSpotRepository(factory);
    }

}
