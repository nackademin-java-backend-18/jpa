package se.coredev.extreme;


import se.coredev.extreme.data.Department;
import se.coredev.extreme.data.Employee;
import se.coredev.extreme.repository.DepartmentRepository;
import se.coredev.extreme.repository.EmployeeRepository;
import se.coredev.extreme.repository.jpa.JpaDepartmentRepository;
import se.coredev.extreme.repository.jpa.JpaEmployeeRepository;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public final class Main {

    private static final EntityManagerFactory factory = Persistence.createEntityManagerFactory("PersistenceUnit");

    public static void main(String[] args) {

//        EmployeeRepository repository = new JpaEmployeeRepository(factory);
//        Employee employee = repository.saveOrUpdate(new Employee("Luke", "Skywalker", "1001"));
//        System.out.println(employee);
//
//        Employee fromStorage = repository.getByNumber("1001");
//        System.out.println(fromStorage);


        DepartmentRepository repository = new JpaDepartmentRepository(factory);
        Department department = repository.saveOrUpdate(new Department("Dev"));
        System.out.println(department);
    }
}
