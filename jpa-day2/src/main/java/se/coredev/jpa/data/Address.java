package se.coredev.jpa.data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Collection;

@Entity
public class Address {

    @Id
    @GeneratedValue
    private Long id;

    private String street;
    private String postal;
    private String zip;

    @OneToMany(mappedBy = "address")
    private Collection<User> users;

    protected Address() {
    }

    public Address(String street, String postal, String zip) {
        this.street = street;
        this.postal = postal;
        this.zip = zip;
    }

    public Long getId() {
        return id;
    }

    public String getStreet() {
        return street;
    }

    public String getPostal() {
        return postal;
    }

    public String getZip() {
        return zip;
    }

    public Collection<User> getUsers() {
        return users;
    }
}
