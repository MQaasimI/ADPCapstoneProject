/* LessonTypeFactory.java
LessonTypeFactory model class
Author: Rameez Karriem (222357320)
Date: 26 March 2026
*/
/*
 * LessonTypeFactory.java
 * LessonTypeFactory class
 * Author: Rameez Karriem (222357320)
 * Date: 26 March 2026
 */
package za.ac.cput.factory;

import za.ac.cput.domain.LessonType;
import za.ac.cput.util.Helper;
import java.time.LocalTime;

// LessonTypeFactory class responsible for creating LessonType objects with validation.

public class LessonTypeFactory {

    public static LessonType createLessonType(String lessonId,
                                              String typeName,
                                              double price,
                                              LocalTime duration,
                                              String description){

        // Validate String inputs
        if(Helper.isNullOrEmpty(lessonId)
                || Helper.isNullOrEmpty(typeName)
                || Helper.isNullOrEmpty(description)){
            return null;
        }

        // Validate price (must be >= 0)
        if(price < 0){
            return null;
        }

        // Validate duration (must not be null and should represent a positive time)
        if(duration == null || (duration.getHour() == 0 && duration.getMinute() == 0)){
            return null;
        }

        // Build and return LessonType object
        return new LessonType.Builder()
                .setLessonId(lessonId)
                .setTypeName(typeName)
                .setPrice(price)
                .setDuration(duration)  // Now passing LocalTime directly
                .setDescription(description)
                .build();
    }
}