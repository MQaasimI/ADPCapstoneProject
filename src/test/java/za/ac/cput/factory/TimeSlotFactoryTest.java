/* TimeSlotFactoryTest.java
   Test class for TimeSlotFactory
   Author: Redah Gamieldien (222641681)
   Date: 26 March 2026
 */

package za.ac.cput.factory;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.domain.TimeSlot;
import java.time.LocalDate;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

// Enables tests to run in order using @Order annotations
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TimeSlotFactoryTest {

    // Test 1: Create a valid time slot with all fields
    @Test
    @Order(1)
    public void testCreateTimeSlot() {
        TimeSlot timeSlot = TimeSlotFactory.createTimeSlot(
                "001",                        // slotId
                LocalTime.of(9, 0),             // startTime
                LocalTime.of(10, 0),            // endTime
                LocalDate.of(2026, 3, 25),      // date
                false                           // isBooked
        );
        assertNotNull(timeSlot);  // Verify time slot was created
    }

    // Test 2: Create a time slot where end time is before start time
    @Test
    @Order(2)
    public void testCreateTimeSlotWithEndTimeBeforeStartTime() {
        TimeSlot timeSlot = TimeSlotFactory.createTimeSlot(
                "001",                        // slotId
                LocalTime.of(10, 0),            // startTime
                LocalTime.of(9, 0),             // endTime (before startTime)
                LocalDate.of(2026, 3, 25),      // date
                false                           // isBooked
        );
        assertNull(timeSlot);  // Verify time slot was NOT created
    }

    // Test 3: Create a time slot that is already booked
    @Test
    @Order(3)
    public void testCreateTimeSlotAlreadyBooked() {
        TimeSlot timeSlot = TimeSlotFactory.createTimeSlot(
                "002",                        // slotId
                LocalTime.of(11, 0),            // startTime
                LocalTime.of(12, 0),            // endTime
                LocalDate.of(2026, 3, 25),      // date
                true                            // isBooked
        );
        assertNotNull(timeSlot);  // Verify time slot was created
    }

}
