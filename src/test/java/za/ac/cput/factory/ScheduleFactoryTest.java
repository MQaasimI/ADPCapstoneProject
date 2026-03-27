/*
 * ScheduleFactoryTest.java
 * ScheduleFactoryTest class
 * Author: Angelo Adams(230450431)
 * Date: 26 March 2026
*/

package za.ac.cput.factory;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.domain.Learner;
import za.ac.cput.domain.MockTest;
import za.ac.cput.domain.Schedule;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;


    @TestMethodOrder(MethodOrderer.OrderAnnotation.class)
    public class ScheduleFactoryTest {


        // Test 1: Create a valid schedule with all fields
        @Test
        @Order(1)  // Runs first
        public void testCreateSchedule() {

            Schedule schedule = ScheduleFactory.createSchedule(
                    "AB01",                // scheduleId
                    "C001", // instructorId
                    LocalDate.of(2026, 6,22 ),                     // date
                    "Accepted"             // status
            );
            assertNotNull(schedule);  // Verify schedule was created
        }
        // Test 2: Create a schedule with an empty testId type
        @Test
        @Order(2)
        public void testCreateScheduleWithEmptyScheduleId() {

            Schedule schedule = ScheduleFactory.createSchedule(
                    "",                // scheduleId (empty)
                    "C001", // instructorId
                    LocalDate.of(2026, 6,22 ),                     // vehicleId
                    "Accepted"             // status
            );
            assertNull(schedule);  // Verify schedule was NOT created
        }

    }
