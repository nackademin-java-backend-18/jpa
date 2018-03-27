package se.coredev.jpa;

import se.coredev.jpa.data.User;
import se.coredev.jpa.repository.UserRepository;
import se.coredev.jpa.repository.sql.JpaFactory;

import java.util.List;

import static java.lang.System.out;

public final class Main {

    public static void main(String[] args) {

        UserRepository repository = JpaFactory.createUserRepository();

        // Add User
        // User user = repository.addUser(new User("Luke", "Skywalker", "lusk01", "secret"));

        // Get User by Id
        // User user = repository.getUser(1L);
        // out.println(user);

        // Get all Users
        List<User> users = repository.getAllUsers();
        users.forEach(out::println);
    }
}