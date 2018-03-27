package se.coredev.jpa.repository;

import se.coredev.jpa.data.User;

import java.util.List;

public interface UserRepository {

    User addUser(User user);

    User updateUser(User user);

    User getUser(Long id);

    List<User> getAllUsers();
}
