package se.coredev.extreme.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries(
    @NamedQuery(name = "Employee.GetByEmployeeNumber", query = "SELECT e FROM Employee e WHERE e.employeeNumber = :number")
)
public class Employee extends AbstractEntity {

    @Column(nullable = false)
    private String firstName;
    @Column(nullable = false)
    private String lastName;
    @Column(nullable = false)
    private String employeeNumber;

    protected Employee() {
    }

    public Employee(String firstName, String lastName, String employeeNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.employeeNumber = employeeNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmployeeNumber() {
        return employeeNumber;
    }

    @Override
    public String toString() {
        return String.format("First name:%s, Last name:%s", firstName, lastName);
    }
}
