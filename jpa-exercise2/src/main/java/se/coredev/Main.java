package se.coredev;

import se.coredev.data.Department;
import se.coredev.data.Employee;
import se.coredev.data.ParkingSpot;
import se.coredev.repository.DepartmentRepository;
import se.coredev.repository.EmployeeRepository;
import se.coredev.repository.ParkingSpotRepository;
import se.coredev.repository.jpa.JpaRepositoryFactory;

import java.util.Arrays;

public final class Main {

    public static void main(String[] args) {
        ParkingSpotRepository parkingSpotRepository = JpaRepositoryFactory.createParkingSpotRepository();
        DepartmentRepository departmentRepository = JpaRepositoryFactory.createDepartmentRepository();
        EmployeeRepository employeeRepository = JpaRepositoryFactory.createEmployeeRepository();

        ParkingSpot parkingSpot = parkingSpotRepository.addParkingSpot(new ParkingSpot("A-14"));
        Department dev = departmentRepository.addDepartment(new Department("Developent"));
        Department hr = departmentRepository.addDepartment(new Department("Human Resources"));

        Employee employee = employeeRepository
                .addEmployee(new Employee("Luke", "Skywalker", "E-1001", Arrays.asList(dev, hr), parkingSpot));

        System.out.println(employee);
    }
}