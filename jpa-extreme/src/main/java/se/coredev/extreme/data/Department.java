package se.coredev.extreme.data;

import javax.persistence.Entity;

@Entity
public class Department extends AbstractEntity {

    private String name;

    protected Department() {
    }

    public Department(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return String.format("Id:%s, Name:%s", getId(), name);
    }
}
