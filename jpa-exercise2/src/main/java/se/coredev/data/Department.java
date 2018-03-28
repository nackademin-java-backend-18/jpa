package se.coredev.data;

import javax.persistence.*;
import java.util.Collection;
import java.util.Collections;

@Entity
public class Department {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String name;

    @ManyToMany(mappedBy = "departments")
    private Collection<Employee> employees;

    protected Department(){}

    public Department(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Collection<Employee> getEmployees() {
        return employees;
    }

    @Override
    public String toString() {
        return String.format("Id:%s, Name:%s", id, name);
    }
}
