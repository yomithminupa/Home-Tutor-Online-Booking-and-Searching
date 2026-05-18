//IT25102587
package com.example.hometutor.repository;

// Import Booking entity class
import com.example.hometutor.model.Booking;
// Import JpaRepository interface
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, String> {
}
