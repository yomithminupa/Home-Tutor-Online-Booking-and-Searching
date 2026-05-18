// IT25102587
package com.example.hometutor.model;

// Import JPA annotations
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

// Marks this class as adatabase entity
@Entity
    
// Maps this class to "Bookings" table   
@Table(name = "bookings")
public class Booking implements IdentifiableEntity {
    
    // primary key
    @Id
    private String id;
    
    // User ID cannot be null
    @Column(nullable = false)
    private String userId;
    
    // Tutor ID cannot be null
    @Column(nullable = false)
    private String tutorId;
    
    // Subject name
    private String subject;
    
    // Booking date
    private String bookingDate;
    
    // Booking time
    private String bookingTime;
    
    // Session location
    private String location;
    
    // Booking status
    private String status;
    
    // Session type
    private String sessionType;
    
    // Default constructor
    public Booking() {
    }
    // Constructor with all field
    public Booking(String id, String userId, String tutorId, String subject, String bookingDate,
                   String bookingTime, String location, String status, String sessionType) {
        this.id = id;
        this.userId = userId;
        this.tutorId = tutorId;
        this.subject = subject;
        this.bookingDate = bookingDate;
        this.bookingTime = bookingTime;
        this.location = location;
        this.status = status;
        this.sessionType = sessionType;
    }
    // Returns booking confirmation message
    public String getConfirmationMessage() {
        // Check session type
        if ("ONLINE".equalsIgnoreCase(sessionType)) {
            return "Online session confirmed for " + bookingDate + " at " + bookingTime;
        }
        // Home visit message
        return "Home visit session confirmed for " + bookingDate + " at " + bookingTime;
    }
    // Returns booking ID
    @Override
    public String getId() {
        return id;
    }
    // Sets user ID
    public void setId(String id) {
        this.id = id;
    }
    // Returns user ID
    public String getUserId() {
        return userId;
    }
    // Sets user ID 
    public void setUserId(String userId) {
        this.userId = userId;
    }
    // Returns tutor ID 
    public String getTutorId() {
        return tutorId;
    }
    // Sets tutor ID
    public void setTutorId(String tutorId) {
        this.tutorId = tutorId;
    }
    // Returns subject
    public String getSubject() {
        return subject;
    }
    // Sets subject
    public void setSubject(String subject) {
        this.subject = subject;
    }
    // Returns booking date
    public String getBookingDate() {
        return bookingDate;
    }
    // Sets booking date
    public void setBookingDate(String bookingDate) {
        this.bookingDate = bookingDate;
    }
    // Returns booking time
    public String getBookingTime() {
        return bookingTime;
    }
    // Sets booking time
    public void setBookingTime(String bookingTime) {
        this.bookingTime = bookingTime;
    }
    // Returns location
    public String getLocation() {
        return location;
    }
    // Sets location
    public void setLocation(String location) {
        this.location = location;
    }
    // Retuns booking status 
    public String getStatus() {
        return status;
    }
    // sets booking status
    public void setStatus(String status) {
        this.status = status;
    }
    // Returns session type
    public String getSessionType() {
        return sessionType;
    }
    // Sets session type
    public void setSessionType(String sessionType) {
        this.sessionType = sessionType;
    }
}
