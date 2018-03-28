package se.coredev.data;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Employee {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String firstName;
    @Column(nullable = false)
    private String lastName;
    @Column(nullable = false)
    private String employeeNumber;

    @ManyToMany
    private Collection<Department> departments;

    @OneToOne
    @JoinColumn(unique = true)
    private ParkingSpot parkingSpot;

    protected Employee() {
    }

    public Employee(String firstName, String lastName, String employeeNumber, Collection<Department> departments, ParkingSpot parkingSpot) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.employeeNumber = employeeNumber;
        this.departments = departments;
        this.parkingSpot = parkingSpot;
    }

    public Collection<Department> getDepartments() {
        return departments;
    }

    public ParkingSpot getParkingSpot() {
        return parkingSpot;
    }

    public Long getId() {
        return id;
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
        return String.format("Id:%s, First name:%s, Last name:%s, Employee number:%s", id, firstName, lastName, employeeNumber);
    }
}
