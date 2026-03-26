package za.ac.cput.factory;

import za.ac.cput.domain.User;
import za.ac.cput.util.Helper;

// Factory class to create User objects
public class UserFactory {
    public static User createUser(String userId,
                                  String fullName,
                                  String username,
                                  String password,
                                  String email) {

        // Validate inputs using a method in the Helper class
        if (Helper.isNullOrEmpty(userId) ||
                Helper.isNullOrEmpty(fullName) ||
                Helper.isNullOrEmpty(username) ||
                Helper.isNullOrEmpty(password) ||
                Helper.isNullOrEmpty(email)) {
            return null;
        }

        // Build and return User
        return new User.Builder().setUserId(userId)
                .setFullName(fullName)
                .setUsername(username)
                .setPassword(password)
                .setEmail(email)
                .build();
    }
}
