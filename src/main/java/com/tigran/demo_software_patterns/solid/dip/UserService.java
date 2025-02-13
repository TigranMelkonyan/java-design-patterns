package com.tigran.demo_software_patterns.solid.dip;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Created by Tigran Melkonyan
 * Date: 2/13/25
 * Time: 3:51 PM
 */
public class UserService {

    private UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public void registerUser(User user) {
        repository.save(user);
    }
}

interface UserRepository {
    void save(User user);

}

class DatabaseUserRepository implements UserRepository {
    public void save(User user) {
        System.out.println("Saving user with id " + user.getId());
    }
}


@Getter
@AllArgsConstructor
class User {
    private String name;
    private int id;
}
