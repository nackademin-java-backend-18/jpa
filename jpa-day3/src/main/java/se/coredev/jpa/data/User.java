package se.coredev.jpa.data;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "Users")
@NamedQueries(
        @NamedQuery(name = "User.getByUsername", query = "SELECT u FROM User u WHERE u.username = :username")
)
public class User {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String username;

    @ManyToOne
    private Role role;

    @ElementCollection
    private Collection<String> metadata;

    protected User(){}

    public User(String username) {
        this.username = username;
    }

    public User(String username, Role role) {
        this.username = username;
        this.role = role;

    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Collection<String> getMetadata() {
        return metadata;
    }

    public void setMetadata(Collection<String> metadata) {
        this.metadata = metadata;
    }

    @Override
    public String toString() {
        return username;
    }
}
