package com.tigran.demo_software_patterns.solid.srp;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Created by Tigran Melkonyan
 * Date: 2/13/25
 * Time: 3:40 PM
 */
public class UserManager {

    private static UserValidator validator = new UserValidator();
    private static UserRepository repository = new UserRepository();
    private static UserDataLogger logger = new UserDataLogger();

    public static void main(String[] args) {
        User user = new User("A", 55);
        validator.validate(user);
        repository.saveUser(user);
        logger.logData(user.getName());

    }
}

class UserValidator {
    public void validate(User user) {
        System.out.println("Validating user with name - " + user.getName());
    }
}

class UserRepository {
    public void saveUser(User user) {
        System.out.println("saving user data for user - " + user.getId());
    }
}

class UserDataLogger {
    public void logData(String data) {
        System.out.println("logging user data" + data);
    }
}

@Getter
@AllArgsConstructor
class User {
    private String name;
    private int id;
}
