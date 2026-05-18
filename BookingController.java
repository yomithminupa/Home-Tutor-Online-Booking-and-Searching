// IT25102587
package com.example.hometutor.controller;
// Import Booking model class
import com.example.hometutor.model.Booking;
// Import BookingService class
import com.example.hometutor.service.BookingService;
// Spring MVc imports
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
// Marks this class as a Spring MVC controller
@Controller
// Base URL for all booking operations 
@RequestMapping("/bookings")
public class BookingController {
    // BookingService object
    private final BookingService bookingService;
    // Constructor injection
    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }
    // Display all booking
    @GetMapping
    public String list(@RequestParam(required = false) String keyword, Model model) {
        // Send booking list to view
        model.addAttribute("bookings", bookingService.search(keyword));
        // Send search keyword to view
        model.addAttribute("keyword", keyword == null ? "" : keyword);
        // open bookings.html page
        return "bookings";
    }
    // Open new booking form
    @GetMapping("/new")
    public String newForm() {
        // Open booking-form.html page
        return "booking-form";
    }
    // Create new booking
    @PostMapping
    public String create(@RequestParam String id, @RequestParam String userId, @RequestParam String tutorId,
                         @RequestParam String subject, @RequestParam String bookingDate,
                         @RequestParam String bookingTime, @RequestParam String location,
                         @RequestParam String status, @RequestParam String sessionType) {
        // Build Booking object
        Booking booking = bookingService.buildBooking(id, userId, tutorId, subject, bookingDate, bookingTime, location, status, sessionType);
        // Save booking
        bookingService.create(booking);
        // Redirect to booking list page
        return "redirect:/bookings";
    }
    // Open edit form using booking ID
    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable String id, Model model) {
        // Find booking and send to view 
        model.addAttribute("booking", bookingService.findById(id).orElse(null));
        // Open booking-form.html page 
        return "booking-form";
    }
    // Update existing booking
    @PostMapping("/edit/{id}")
    public String update(@PathVariable String id, @RequestParam String userId, @RequestParam String tutorId,
                         @RequestParam String subject, @RequestParam String bookingDate,
                         @RequestParam String bookingTime, @RequestParam String location,
                         @RequestParam String status, @RequestParam String sessionType) {
        // Build update booking object
        Booking booking = bookingService.buildBooking(id, userId, tutorId, subject, bookingDate, bookingTime, location, status, sessionType);
        // Update booking
        bookingService.update(booking);
        // Redirect to booking list page
        return "redirect:/bookings";
    }
    // Delete booking using ID
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable String id) {
        // Delete booking
        bookingService.delete(id);
        // Redirect to booking list page
        return "redirect:/bookings";
    }
}
