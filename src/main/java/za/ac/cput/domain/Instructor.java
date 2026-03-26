/* Instructor.java
Instructor model class
Author: Qaasim Isaacs (222544422)
Date: 25 March 2026
*/

package za.ac.cput.domain;

/**
 * Instructor class represents an instructor in our system with attributes like the id for instructor, employeeCode, the specialization, the rating and the userid.
 */

public class Instructor {
    private String instructorId;
    private String employeeCode;
    private String specialisation;
    private double rating;
    private String userId;

    // Default constructor
    public Instructor() {

    }

    // Private constructor for Builder pattern
    private Instructor(Builder builder) {
        this.instructorId = builder.instructorId;
        this.employeeCode = builder.employeeCode;
        this.specialisation = builder.specialisation;
        this.rating = builder.rating;
        this.userId = builder.userId;
    }

    // Getters
    public String getInstructorId() {
        return instructorId;
    }

    public String getEmployeeCode() {
        return employeeCode;
    }

    public String getSpecialisation() {
        return specialisation;
    }

    public double getRating() {
        return rating;
    }

    public String getUserId() {
        return userId;
    }

    // Builder pattern
    public static class Builder {
        private String instructorId;
        private String employeeCode;
        private String specialisation;
        private double rating;
        private String userId;

        // Setter methods for Builder (method chaining)
        public Builder setInstructorId(String instructorId) {
            this.instructorId = instructorId;
            return this;
        }

        public Builder setEmployeeCode(String employeeCode) {
            this.employeeCode = employeeCode;
            return this;
        }

        public Builder setSpecialisation(String specialisation) {
            this.specialisation = specialisation;
            return this;
        }

        public Builder setRating(double rating) {
            this.rating = rating;
            return this;
        }

        public Builder setUserId(String userId) {
            this.userId = userId;
            return this;
        }

        public Builder copy(Instructor instructor) {
            this.instructorId = instructor.getInstructorId();
            this.employeeCode = instructor.getEmployeeCode();
            this.specialisation = instructor.getSpecialisation();
            this.rating = instructor.getRating();
            this.userId = instructor.getUserId();
            return this;
        }

        // Build method
        public Instructor build() {
            return new Instructor(this);
        }
    }
}
