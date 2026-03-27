/* Booking.java
Booking model class
Author: Rameez Karriem (222357320)
Date: 25 March 2026
*/

package za.ac.cput.domain;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * Represents a booking entity in the system.
 * It uses attributes like id, bookingdate, timeslot and status
 * Uses the Builder pattern for object construction.
 */
public class Booking {
    private String bookingId;    
    private LocalDate bookingDate;    
    private LocalTime timeSlot;       
    private String status;         
    private String learnerId;        
    private String instructorId;      

    
    //public default constructor.
    public Booking() {
    }

    //Private constructor for Builder pattern.
    private Booking(Builder builder) {
        this.bookingId = builder.bookingId;
        this.bookingDate = builder.bookingDate;
        this.timeSlot = builder.timeSlot;
        this.status = builder.status;
        this.learnerId = builder.learnerId;
        this.instructorId = builder.instructorId;
    }

    // Getters 

    public String getBookingId() {
        return bookingId;
    }

   
    public LocalDate getBookingDate() {
        return bookingDate;
    }

   
    public LocalTime getTimeSlot() {
        return timeSlot;
    }

  
    public String getStatus() {
        return status;
    }

    
    public String getLearnerId() {
        return learnerId;
    }

   
    public String getInstructorId() {
        return instructorId;
    }
    
   //Builder pattern
    public static class Builder {
        private String bookingId;
        private LocalDate bookingDate;
        private LocalTime timeSlot;
        private String status;
        private String learnerId;
        private String instructorId;

        // Setter methods for Builder, returns a builder for chaining
        public Builder setBookingId(String bookingId) {
            this.bookingId = bookingId;
            return this;  
        }

        
        public Builder setBookingDate(LocalDate bookingDate) {
            this.bookingDate = bookingDate;
            return this;
        }

      
        public Builder setTimeSlot(LocalTime timeSlot) {
            this.timeSlot = timeSlot;
            return this;
        }

        public Builder setStatus(String status) {
            this.status = status;
            return this;
        }

    
        public Builder setLearnerId(String learnerId) {
            this.learnerId = learnerId;
            return this;
        }

   
        public Builder setInstructorId(String instructorId) {
            this.instructorId = instructorId;
            return this;
        }

       
        public Builder copy(Booking booking) {
            this.bookingId = booking.bookingId;
            this.bookingDate = booking.bookingDate;
            this.timeSlot = booking.timeSlot;
            this.status = booking.status;
            this.learnerId = booking.learnerId;
            this.instructorId = booking.instructorId;
            return this;
        }

       // builds the user object from the Builder
        public Booking build() {
            return new Booking(this);
        }
    }
}
