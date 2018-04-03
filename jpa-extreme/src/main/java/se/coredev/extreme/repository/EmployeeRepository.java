package se.coredev.extreme.repository;

import se.coredev.extreme.data.Employee;

public interface EmployeeRepository extends CrudRepository<Employee> {

    Employee getByNumber(String number);

}
