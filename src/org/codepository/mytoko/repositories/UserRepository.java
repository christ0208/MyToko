package org.codepository.mytoko.repositories;

import org.codepository.mytoko.models.entity.User;

import java.util.Vector;
import java.util.stream.Collectors;

public class UserRepository extends Repository {
    private static UserRepository instance;
    private Vector<User> users;

    private UserRepository() {
        this.users = new Vector<>();
    }

    public Vector<User> get() {
        return this.users;
    }

    @Override
    public Object get(String username) {
        User[] selectedUser = (User[]) this.users
                .stream()
                .filter(d -> d.getUsername().equals(username))
                .collect(Collectors.toList())
                .toArray();
        return selectedUser[0];
    }

    @Override
    public Object add(Object o) {
        User newUser = (User) o;
        this.users.add(newUser);

        return newUser;
    }

    public static UserRepository getInstance() {
        if (instance == null)
            instance = new UserRepository();

        return instance;
    }
}
