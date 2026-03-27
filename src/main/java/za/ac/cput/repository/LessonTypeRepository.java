/*
 * LessonTypeRepository.java
 * LessonTypeRepository class
 * Author: Rameez Karriem (222357320)
 * Date: 27 March 2026
 */
package za.ac.cput.repository;

import za.ac.cput.domain.LessonType;

import java.util.ArrayList;
import java.util.List;

// Repository class for LessonType entities with CRUD operations
public class LessonTypeRepository implements IRepository<LessonType, String> {

    // Singleton instance of LessonTypeRepository
    public static LessonTypeRepository repository = null;

    // List to store LessonType objects
    private List<LessonType> lessonTypeList;

    // Private constructor to prevent external instantiation
    private LessonTypeRepository() {
        lessonTypeList = new ArrayList<>();
    }

    // Method to get the singleton instance of LessonTypeRepository
    public static LessonTypeRepository getRepository() {
        if (repository == null) {
            repository = new LessonTypeRepository();
        }
        return repository;
    }

    // Create a new LessonType and add to the list
    @Override
    public LessonType create(LessonType lessonType) {
        boolean success = lessonTypeList.add(lessonType);
        if (success) {
            return lessonType;
        }
        return null;
    }

    // Read a LessonType by its ID
    @Override
    public LessonType read(String lessonId) {
        for (LessonType lessonType : lessonTypeList) {
            if (lessonType.getLessonId().equals(lessonId)) {
                return lessonType;
            }
        }
        return null;
    }

    // Update an existing LessonType
    @Override
    public LessonType update(LessonType lessonType) {
        String id = lessonType.getLessonId();
        LessonType oldLessonType = read(id);

        if (oldLessonType != null) {
            lessonTypeList.remove(oldLessonType); // Remove old entry
            lessonTypeList.add(lessonType);       // Add updated entry
            return lessonType;
        }
        return null;
    }

    // Delete a LessonType by ID
    @Override
    public boolean delete(String id) {
        LessonType lessonTypeToDelete = read(id);

        if (lessonTypeToDelete != null) {
            lessonTypeList.remove(lessonTypeToDelete);
            return true;
        }
        return false;
    }

    // Get all LessonType objects
    @Override
    public List<LessonType> getAll() {
        return lessonTypeList;
    }
}