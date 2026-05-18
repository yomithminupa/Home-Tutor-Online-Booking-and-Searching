//IT25102587
package com.example.hometutor.service;
// Import Booking model
import com.example.hometutor.model.Booking;
// Import BookingRepository for database operations
import com.example.hometutor.repository.BookingRepository;
// Marks this class as a Spring Service 
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;
/*
 * BookingService Class
 *
 * Purpose:
 * This class handle all business logic related to booking.
 * It extends AbstractCrudService to reuse common CRUD operations.
 */
@Service
public class BookingService extends AbstractCrudService<Booking> {
    // Costructor injection of repository
    public BookingService(BookingRepository bookingRepository) {
        super(bookingRepository);
    }
    /*
     * Creates a Booking object from given parameters
     */
    public Booking buildBooking(String id, String userId, String tutorId, String subject, String bookingDate,
                                String bookingTime, String location, String status, String sessionType) {
        return new Booking(id, userId, tutorId, subject, bookingDate, bookingTime, location, status, sessionType);
    }
    /*
     * Search booking by keyword
     * If keyword is empty returns all bookings
     */
    @Override
    public List<Booking> search(String keyword) {

        // If no keyword given, return all records
        if (keyword == null || keyword.isBlank()) {
            return findAll();
        }
        // Convert keyword to lowercase for case-insensitive search
        String query = keyword.toLowerCase(Locale.ROOT);
        // Filter booking based on keyword match
        return findAll().stream()
                .filter(booking -> contains(booking.getId(), query)
                        || contains(booking.getUserId(), query)
                        || contains(booking.getTutorId(), query)
                        || contains(booking.getSubject(), query)
                        || contains(booking.getStatus(), query)
                        || contains(booking.getSessionType(), query))
                .toList();
    }
    /*
     * Helper method to check if value contains search keyword
     */
    private static boolean contains(String value, String query) {
        return value != null && value.toLowerCase(Locale.ROOT).contains(query);
    }
}
