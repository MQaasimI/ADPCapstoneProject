/*
 * MockTestRepositoryTest.java
 * MockTestRepositoryTest class
 * Author: Angelo Adams (230450431)
 * Date: 27 March 2026
 */

package za.ac.cput.respository;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.domain.MockTest;
import za.ac.cput.factory.MockTestFactory;
import za.ac.cput.repository.MockTestRepository;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

// Test class for MockTestRepository  CRUD operations
public class MockTestRepositoryTest {

    // Get singleton instance of repository
    private final MockTestRepository mockTestRepository = MockTestRepository.getRepository();

    // Helper method to create a sample mocktest
    private MockTest createMockTest() {
        return MockTestFactory.createMockTest(
                "A001",
                "UT01",
                LocalDate.of(2026, 6,25 ),
                50,
                true
        );
    }

    @Test
    @Order(1)
    void create() {
        MockTest mockTest = createMockTest();

        // Save mocktest to repository
        MockTest created = mockTestRepository.create(mockTest);

        // Check mockTest was created
        assertNotNull(created);
    }

    @Test
    @Order(2)
    void read() {
        MockTest mockTest = createMockTest();
        mockTestRepository.create(mockTest);

        // Retrieve mocktest by ID
        MockTest found = mockTestRepository.read(mockTest.getTestId());

        // Check mocktest exists
        assertNotNull(found);
    }

    @Test
    @Order(3)
    void update() {
        MockTest mockTest = createMockTest();
        mockTestRepository.create(mockTest);

        // Modify existing mockTest (change learnerId only)
        MockTest updatedMockTest = new MockTest.Builder()
                .copy(mockTest)
                .setTestId("UD03")
                .build();

        // Update in repository
        MockTest updated = mockTestRepository.update(updatedMockTest);

        // Verify update worked
        assertNotNull(updated);
        assertEquals("UD03", updated.getLearnerId());
    }

    @Test
    @Order(4)
    void delete() {
        MockTest mockTest = createMockTest();
        mockTestRepository.create(mockTest);

        // Delete MockTest by ID
        boolean deleted = mockTestRepository.delete(mockTest.getTestId());

        // Verify deletion was successful
        assertTrue(deleted);
    }

    @Test
    @Order(5)
    void getAll() {

        // Add an admin to repository
        mockTestRepository.create(createMockTest());

        // Check repository is not empty
        assertFalse(mockTestRepository.getAll().isEmpty());
     }
}
