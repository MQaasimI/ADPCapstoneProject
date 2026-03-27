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
import za.ac.cput.domain.Schedule;
import za.ac.cput.factory.ScheduleFactory;
import za.ac.cput.repository.ScheduleRepository;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

// Test class for Schedule CRUD operations
public class ScheduleRepositoryTest {

    // Get singleton instance of repository
    private final ScheduleRepository scheduleRepository = ScheduleRepository.getRepository();

    // Helper method to create a sample admin
    private Schedule createSchedule() {
        return ScheduleFactory.createSchedule(
                "AB01",
                "C001",
                LocalDate.of(2026, 6,22 ),
                "Accepted"
        );
    }

    @Test
    @Order(1)
    void create() {
        Schedule schedule = createSchedule();

        // Save schedulet to repository
        Schedule created = scheduleRepository.create(schedule);

        // Check schedule was created
        assertNotNull(created);
    }

    @Test
    @Order(2)
    void read() {
        Schedule schedule = createSchedule();
        scheduleRepository.create(schedule);

        // Retrieve schedule by ID
        Schedule found = scheduleRepository.read(schedule.getScheduleId());

        // Check schedule exists
        assertNotNull(found);
    }

    @Test
    @Order(3)
    void update() {
        Schedule schedule = createSchedule();
        scheduleRepository.create(schedule);

        // Modify existing mockTest (change learnerId only)
        Schedule updatedSchedule = new Schedule.Builder()
                .copy(schedule)
                .setScheduleId("ABB1")
                .build();

        // Update in repository
        Schedule updated = scheduleRepository.update(updatedSchedule);

        // Verify update worked
        assertNotNull(updated);
        assertEquals("ABB1", updated.getScheduleId());
    }

    @Test
    @Order(4)
    void delete() {
        Schedule schedule = createSchedule();
        scheduleRepository.create(schedule);

        // Delete Schedule by ID
        boolean deleted = scheduleRepository.delete(schedule.getScheduleId());

        // Verify deletion was successful
        assertTrue(deleted);
    }

    @Test
    @Order(5)
    void getAll() {

        // Add an schedule  to  repository
        scheduleRepository.create(createSchedule());

        // Check repository is not empty
        assertFalse(scheduleRepository.getAll().isEmpty());
     }
}