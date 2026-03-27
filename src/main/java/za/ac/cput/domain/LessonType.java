/*
 * LessonType.java
 * LessonType class
 * Author: Rameez Karriem (222357320)
 * Date: 25 March 2026
 */
package za.ac.cput.domain;

// Immutable LessonType entity with Builder pattern for flexible construction
public class LessonType {
    private String lessonId;         // Unique identifier for the lesson type
    private String typeName;         // Name of the lesson type
    private double price;            // Price per lesson for this lesson type
    private int duration;            // Duration of the lesson in minutes
    private String description;      // Detailed description of the lesson type

    // Public default constructor
    public LessonType() {
    }

    // Private constructor called by Builder's build() method
    private LessonType(LessonType.Builder builder) {
        this.lessonId = builder.lessonId;
        this.typeName = builder.typeName;
        this.price = builder.price;
        this.duration = builder.duration;
        this.description = builder.description;
    }

    // Getters - no setters to maintain immutability
    public String getLessonId() {
        return lessonId;
    }

    public String getTypeName() {
        return typeName;
    }

    public double getPrice() {
        return price;
    }

    public int getDuration() {
        return duration;
    }

    public String getDescription() {
        return description;
    }

    // Builder class for constructing LessonType objects
    public static class Builder {
        private String lessonId;         // Unique identifier for the lesson type
        private String typeName;         // Name of the lesson type
        private double price;            // Price per lesson
        private int duration;            // Duration in minutes
        private String description;      // Detailed description

        public Builder setLessonId(String lessonId) {
            this.lessonId = lessonId;
            return this;
        }

        public Builder setTypeName(String typeName) {
            this.typeName = typeName;
            return this;
        }

        public Builder setPrice(double price) {
            this.price = price;
            return this;
        }

        public Builder setDuration(int duration) {
            this.duration = duration;
            return this;
        }

        public Builder setDescription(String description) {
            this.description = description;
            return this;
        }

        // Copies values from an existing LessonType object to the Builder
        public Builder copy(LessonType lessontype) {
            this.lessonId = lessontype.lessonId;
            this.typeName = lessontype.typeName;
            this.price = lessontype.price;
            this.duration = lessontype.duration;
            this.description = lessontype.description;
            return this;
        }

        // Builds and returns a new LessonType object
        public LessonType build() {
            return new LessonType(this);
        }
    }
}
