package se.coredev.jpa.data;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Role {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String name;

//    @OneToMany(mappedBy = "role", fetch = FetchType.EAGER)
    @OneToMany(mappedBy = "role")
    private Collection<User> users;

    protected Role() {
    }

    public Role(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Collection<User> getUsers() {
        return users;
    }
}
