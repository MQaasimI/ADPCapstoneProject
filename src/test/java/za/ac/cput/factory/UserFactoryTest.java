/* UserFactory.java
User Factory testing class
Author: Lyle Solomons (230123872)
Date: 26 March 2026
*/

package za.ac.cput.factory;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.User;

import static org.junit.jupiter.api.Assertions.*;

public class UserFactoryTest {

    @Test
    @Order(1)
    public void testCreateUser() {

        User user =  UserFactory.createUser(
                "U001",
                "Lyle Solomons",
                "sollyBug",
                "IloveCake",
                "230123872@mycput.ac.za"
        );

        assertNotNull(user); //pass if all fields are not null
    }

    @Test
    @Order(2)
    public void testCreateUserWithEmptyFUllName() {

        User user = UserFactory.createUser(
                "U002",
                "", // empty fullName
                "sollyBug",
                "IloveCake",
                "230123872@mycput.ac.za"
        );

        assertNull(user); // pass if a field is null
    }

}
