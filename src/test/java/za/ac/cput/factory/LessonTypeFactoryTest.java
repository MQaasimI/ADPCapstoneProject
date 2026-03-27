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
import za.ac.cput.domain.User;

import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class LessonTypeFactoryTest {

    @Test
    @Order(1)
    void createLessonType() {
        // Create LocalTime object for duration
        LocalTime duration = LocalTime.of(1, 30); // 1 hour and 30 minutes

        LessonType lessonType = LessonTypeFactory.createLessonType(
                "222355662",    // lessonId (String)
                "code 8",       // typeName
                2000.00,        // price (double)
                duration,       // duration (LocalTime)
                "car"           // description
        );

        assertNotNull(lessonType); // pass if all fields are valid and not null
    }

    @Test
    @Order(2)
    void testCreateLessonTypeWithEmptyLessonId() {
        LocalTime duration = LocalTime.of(1, 30);

        LessonType lessonType = LessonTypeFactory.createLessonType(
                "",             // empty lessonId
                "code 8",
                2000.00,
                duration,
                "car"
        );

        assertNull(lessonType); // pass if lessonId is empty/null
    }

    @Test
    @Order(3)
    void testCreateLessonTypeWithEmptyTypeName() {
        LocalTime duration = LocalTime.of(1, 30);

        LessonType lessonType = LessonTypeFactory.createLessonType(
                "222355662",
                "",             // empty typeName
                2000.00,
                duration,
                "car"
        );

        assertNull(lessonType); // pass if typeName is empty/null
    }

    @Test
    @Order(4)
    void testCreateLessonTypeWithEmptyDescription() {
        LocalTime duration = LocalTime.of(1, 30);

        LessonType lessonType = LessonTypeFactory.createLessonType(
                "222355662",
                "code 8",
                2000.00,
                duration,
                ""              // empty description
        );

        assertNull(lessonType); // pass if description is empty/null
    }

    @Test
    @Order(5)
    void testCreateLessonTypeWithInvalidPrice() {
        LocalTime duration = LocalTime.of(1, 30);

        LessonType lessonType = LessonTypeFactory.createLessonType(
                "222355662",
                "code 8",
                -100.00,        // invalid negative price
                duration,
                "car"
        );

        assertNull(lessonType); // pass if price is negative
    }

    @Test
    @Order(6)
    void testCreateLessonTypeWithNullDuration() {
        LessonType lessonType = LessonTypeFactory.createLessonType(
                "222355662",
                "code 8",
                2000.00,
                null,           // null duration
                "car"
        );

        assertNull(lessonType); // pass if duration is null
    }

    @Test
    @Order(7)
    void testCreateLessonTypeWithZeroDuration() {
        LocalTime duration = LocalTime.of(0, 0); // zero duration (0 hours, 0 minutes)

        LessonType lessonType = LessonTypeFactory.createLessonType(
                "222355662",
                "code 8",
                2000.00,
                duration,
                "car"
        );

        assertNull(lessonType); // pass if duration is zero
    }

    @Test
    @Order(8)
    void testCreateLessonTypeWithAllValidFields() {
        LocalTime duration = LocalTime.of(1, 30); // 1 hour 30 minutes

        LessonType lessonType = LessonTypeFactory.createLessonType(
                "222355662",
                "code 8",
                2000.00,
                duration,
                "car"
        );

        assertNotNull(lessonType);
        assertEquals("222355662", lessonType.getLessonId());
        assertEquals("code 8", lessonType.getTypeName());
        assertEquals(2000.00, lessonType.getPrice());
        assertEquals(duration, lessonType.getDuration());
        assertEquals("car", lessonType.getDescription());
    }


}