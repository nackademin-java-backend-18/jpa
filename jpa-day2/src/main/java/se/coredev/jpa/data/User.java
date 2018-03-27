package se.coredev.jpa.data;

import javax.persistence.*;

@Entity
@Table(name = "Users")
public class User {

    @Id
    @GeneratedValue
    private Long id;

    private String username;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private Address address;

    protected User() {
    }

    public User(String username, Address address) {
        this.username = username;
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public Address getAddress() {
        return address;
    }
}
