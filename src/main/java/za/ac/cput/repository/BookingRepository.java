/*
 * BookingRepository.java
 * Author: Rameez Karriem (222357320)
 * Date: 27 March 2026
 */
package za.ac.cput.repository;

import za.ac.cput.domain.Booking;

import java.util.ArrayList;
import java.util.List;

public class BookingRepository implements IRepository<Booking, String> {

    // Singleton instance of BookingRepository
    public static BookingRepository repository = null;

    // List to store Booking objects
    private List<Booking> bookingList;

    // Private constructor to prevent external instantiation
    private BookingRepository() {
        bookingList = new ArrayList<>();
    }

    // Method to get the singleton instance of BookingRepository
    public static BookingRepository getRepository() {
        if (repository == null) {
            repository = new BookingRepository();
        }
        return repository;
    }

    // Create a new Booking and add to the list
    @Override
    public Booking create(Booking booking) {
        boolean success = bookingList.add(booking);
        if (success) {
            return booking;
        }
        return null;
    }

    // Read a Booking by its ID
    @Override
    public Booking read(String bookingId) {
        for (Booking booking : bookingList) {
            if (booking.getBookingId().equals(bookingId)) {
                return booking;
            }
        }
        return null;
    }

    // Update an existing Booking
    @Override
    public Booking update(Booking booking) {
        String id = booking.getBookingId();
        Booking oldBooking = read(id);

        if (oldBooking != null) {
            bookingList.remove(oldBooking); // Remove old entry
            bookingList.add(booking);       // Add updated entry
            return booking;
        }
        return null;
    }

    // Delete a Booking by ID
    @Override
    public boolean delete(String id) {
        Booking bookingToDelete = read(id);

        if (bookingToDelete != null) {
            bookingList.remove(bookingToDelete);
            return true;
        }
        return false;
    }

    // Get all Booking objects
    @Override
    public List<Booking> getAll() {
        return bookingList;
    }
}
