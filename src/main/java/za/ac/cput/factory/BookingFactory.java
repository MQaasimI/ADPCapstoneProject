/* BookingFactory.java
BookingFactory class
Author: Rameez Karriem (222357320)
Date: 26 March 2026
*/
/*
 * BookingFactory.java
 * BookingFactory class
 * Author: Rameez Karriem (222357320)
 * Date: 26 March 2026
 */
package za.ac.cput.factory;
import za.ac.cput.domain.Booking;
import za.ac.cput.util.Helper;

import java.time.LocalDate;
import java.time.LocalTime;

// BookingFactory class responsible for creating Booking objects with validation.

public class BookingFactory {

    public static Booking createBooking(String bookingId,
                                        LocalDate bookingDate,
                                        LocalTime timeSlot,
                                        String status,
                                        String learnerId,
                                        String instructorId){

        // Validate String inputs (must not be null or empty)
        if(Helper.isNullOrEmpty(bookingId)
                || Helper.isNullOrEmpty(status)
                || Helper.isNullOrEmpty(learnerId)
                || Helper.isNullOrEmpty(instructorId)){
            return null;
        }

        // Validate bookingDate (must not be null)
        if(bookingDate == null){
            return null;
        }

        // Validate timeSlot (must not be null)
        if(timeSlot == null){
            return null;
        }

        // Build and return Booking object
        return new Booking.Builder()
                .setBookingId(bookingId)
                .setBookingDate(bookingDate)
                .setTimeSlot(timeSlot)
                .setStatus(status)
                .setLearnerId(learnerId)
                .setInstructorId(instructorId)
                .build();
    }
}