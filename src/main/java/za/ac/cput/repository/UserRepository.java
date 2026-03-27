/* UserRepository.java
UserRepository class
Author: Lyle Solomons (230123872)
Date: 26 March 2026
*/

package za.ac.cput.repository;

import za.ac.cput.domain.User;

import java.util.ArrayList;
import java.util.List;

public class UserRepository implements IRepository<User, String> {

    // Singleton instance
    private static UserRepository repository = null;
    // In-memory list to store users
    private List<User> userList;

    // Private constructor
    private UserRepository() {
        userList = new ArrayList<>();
    }

    // Get singleton instance
    public static UserRepository getRepository() {

        if (repository == null) {
            repository = new UserRepository();
        }

        return repository;
    }

    @Override
    public User create(User user) {
        // Add user to list
        boolean success = userList.add(user);

        if (success) {
            return user;
        }
        return null;
    }

    @Override
    public User read(String userId) {
        // Find user by ID
        for (User user : userList) {
            if (user.getUserId().equals(userId)) {
                return user;
            }
        }

        return null;
    }

    @Override
    public User update(User user) {
        String id =  user.getUserId();
        User oldUser = read(id);

        // Replace existing user
        if (oldUser != null) {
            userList.remove(oldUser);
            userList.add(user);
            return user;
        }

        return null;
    }

    @Override
    public boolean delete(String id) {
        User userToDelete = read(id);

        // Remove user if found
        if (userToDelete != null) {
            userList.remove(userToDelete);
            return true;
        }

        return false;
    }

    @Override
    public List<User> getAll() {
        // Return all users
        return userList;
    }
}
