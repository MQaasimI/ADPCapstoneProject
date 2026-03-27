/*
 * LessonTypeFactoryTest.java
 * LessonTypeFactoryTest class
 * Author: Rameez Karriem (222357320)
 * Date: 26 March 2026
 */
package za.ac.cput.factory;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.domain.LessonType;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class LessonTypeFactoryTest {

    @Test
    @Order(1)
    void createLessonType() {
        // Duration in minutes (90 minutes = 1 hour 30 minutes)
        int duration = 90;

        // Create lesson type with valid data
        LessonType lessonType = LessonTypeFactory.createLessonType(
                "222355662",    // Valid lesson ID
                "code 8",       // Valid lesson type name
                2000.00,        // Valid price (positive)
                duration,       // Valid duration (positive integer)
                "car"           // Valid description
        );

        // Verify lesson type was created successfully
        assertNotNull(lessonType);
    }

    @Test
    @Order(2)
    void testCreateLessonTypeWithEmptyLessonId() {
        // Valid duration for testing
        int duration = 90;

        // Attempt to create lesson type with empty lesson ID
        LessonType lessonType = LessonTypeFactory.createLessonType(
                "",             // Empty lesson ID (invalid)
                "code 8",       // Valid type name
                2000.00,        // Valid price
                duration,       // Valid duration
                "car"           // Valid description
        );

        // Verify creation fails with empty lesson ID
        assertNull(lessonType);
    }

    @Test
    @Order(3)
    void testCreateLessonTypeWithEmptyTypeName() {
        // Valid duration for testing
        int duration = 90;

        // Attempt to create lesson type with empty type name
        LessonType lessonType = LessonTypeFactory.createLessonType(
                "222355662",    // Valid lesson ID
                "",             // Empty type name (invalid)
                2000.00,        // Valid price
                duration,       // Valid duration
                "car"           // Valid description
        );

        // Verify creation fails with empty type name
        assertNull(lessonType);
    }

    @Test
    @Order(4)
    void testCreateLessonTypeWithEmptyDescription() {
        // Valid duration for testing
        int duration = 90;

        // Attempt to create lesson type with empty description
        LessonType lessonType = LessonTypeFactory.createLessonType(
                "222355662",    // Valid lesson ID
                "code 8",       // Valid type name
                2000.00,        // Valid price
                duration,       // Valid duration
                ""              // Empty description (invalid)
        );

        // Verify creation fails with empty description
        assertNull(lessonType);
    }

    @Test
    @Order(5)
    void testCreateLessonTypeWithInvalidPrice() {
        // Valid duration for testing
        int duration = 90;

        // Attempt to create lesson type with negative price
        LessonType lessonType = LessonTypeFactory.createLessonType(
                "222355662",    // Valid lesson ID
                "code 8",       // Valid type name
                -100.00,        // Negative price (invalid)
                duration,       // Valid duration
                "car"           // Valid description
        );

        // Verify creation fails with negative price
        assertNull(lessonType);
    }

    @Test
    @Order(6)
    void testCreateLessonTypeWithInvalidDurationZero() {
        // Zero duration for testing edge case
        int duration = 0;

        // Attempt to create lesson type with zero duration
        LessonType lessonType = LessonTypeFactory.createLessonType(
                "222355662",    // Valid lesson ID
                "code 8",       // Valid type name
                2000.00,        // Valid price
                duration,       // Zero duration (invalid)
                "car"           // Valid description
        );

        // Verify creation fails with zero duration
        assertNull(lessonType);
    }

    @Test
    @Order(7)
    void testCreateLessonTypeWithInvalidDurationNegative() {
        // Negative duration for testing boundary case
        int duration = -30;

        // Attempt to create lesson type with negative duration
        LessonType lessonType = LessonTypeFactory.createLessonType(
                "222355662",    // Valid lesson ID
                "code 8",       // Valid type name
                2000.00,        // Valid price
                duration,       // Negative duration (invalid)
                "car"           // Valid description
        );

        // Verify creation fails with negative duration
        assertNull(lessonType);
    }

    @Test
    @Order(8)
    void testCreateLessonTypeWithAllValidFields() {
        // Standard duration for comprehensive testing
        int duration = 90;

        // Create lesson type with all valid fields
        LessonType lessonType = LessonTypeFactory.createLessonType(
                "222355662",    // Valid lesson ID
                "code 8",       // Valid type name
                2000.00,        // Valid positive price
                duration,       // Valid positive duration
                "car"           // Valid description
        );

        // Verify lesson type was created successfully
        assertNotNull(lessonType);

        // Validate all fields match expected values
        assertEquals("222355662", lessonType.getLessonId());
        assertEquals("code 8", lessonType.getTypeName());
        assertEquals(2000.00, lessonType.getPrice());
        assertEquals(duration, lessonType.getDuration());
        assertEquals("car", lessonType.getDescription());
    }
}