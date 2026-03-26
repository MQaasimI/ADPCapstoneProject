/* UserRepositoryTest.java
UserRepositoryTest class
Author: Lyle Solomons (230123872)
Date: 26 March 2026
*/

package za.ac.cput.respository;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.domain.User;
import za.ac.cput.factory.UserFactory;
import za.ac.cput.repository.UserRepository;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

// Test class for UserRepository CRUD operations
public class UserRepositoryTest {

    // Get singleton instance of repository
    private UserRepository userRepository = UserRepository.getRepository();

    // Helper method to create a sample user
    private User createUser() {
        return UserFactory.createUser(
                "U001",
                "Lyle Solomons",
                "sollyBug",
                "IloveCake",
                "230123872@mycput.ac.za");
    }

    @Test
    @Order(1)
    void create() {
        User user = createUser();

        // Save user to repository
        User created = userRepository.create(user);

        // Check user was created
        assertNotNull(created);
    }

    @Test
    @Order(2)
    void read() {
        User user = createUser();
        userRepository.create(user);

        // Retrieve user by ID
        User found = userRepository.read(user.getUserId());

        // Check user exists
        assertNotNull(found);
    }

    @Test
    @Order(3)
    void update() {
        User user = createUser();
        userRepository.create(user);

        // Modify existing user
        User updatedUser = new User.Builder()
                .copy(user)
                .setUsername("BatMan")
                .build();

        // Update in repository
        User updated = userRepository.update(updatedUser);

        // Verify update worked
        assertNotNull(updated);
        assertEquals("BatMan", updated.getUsername());
    }

    @Test
    @Order(4)
    void delete() {
        User user = createUser();
        userRepository.create(user);

        // Delete user by ID
        boolean deleted = userRepository.delete(user.getUserId());

        // Verify deletion was successful
        assertTrue(deleted);
    }

    @Test
    @Order(5)
    void getAll() {

        // Add a user to repository
        userRepository.create(createUser());

        // Check repository is not empty
        assertFalse(userRepository.getAll().isEmpty());
    }

}
