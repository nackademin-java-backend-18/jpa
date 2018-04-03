package se.coredev.extreme.data;

import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries(
        @NamedQuery(name = "Employee.GetByNumber",
                query = "SELECT e FROM Employee e WHERE e.number = :number")
)
public class Employee extends AbstractEntity {

    private String firstName;
    private String lastName;
    private String number;

    protected Employee() {
    }

    public Employee(String firstName, String lastName, String number) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.number = number;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return String.format("Id:%s, First name:%s, Last name:%s, Number:%s",
                getId(), firstName, lastName, number);
    }
}
