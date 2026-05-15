package com.example.hometutor.controller;

import com.example.hometutor.service.BookingService;
import com.example.hometutor.service.PaymentService;
import com.example.hometutor.service.ReviewService;
import com.example.hometutor.service.SubjectService;
import com.example.hometutor.service.TutorService;
import com.example.hometutor.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;
import java.util.Map;

@RestController
public class ApiController {
    private final UserService userService;
    private final TutorService tutorService;
    private final SubjectService subjectService;
    private final BookingService bookingService;
    private final PaymentService paymentService;
    private final ReviewService reviewService;

    public ApiController(UserService userService, TutorService tutorService, SubjectService subjectService,
                         BookingService bookingService, PaymentService paymentService,
                         ReviewService reviewService) {
        this.userService = userService;
        this.tutorService = tutorService;
        this.subjectService = subjectService;
        this.bookingService = bookingService;
        this.paymentService = paymentService;
        this.reviewService = reviewService;
    }

    @GetMapping("/api/summary")
    public Map<String, Object> summary() {
        Map<String, Object> summary = new LinkedHashMap<>();
        summary.put("project", "Home Tutor Search and Booking System");
        summary.put("users", userService.findAll().size());
        summary.put("tutors", tutorService.findAll().size());
        summary.put("subjects", subjectService.findAll().size());
        summary.put("bookings", bookingService.findAll().size());
        summary.put("payments", paymentService.findAll().size());
        summary.put("reviews", reviewService.findAll().size());
        return summary;
    }

    @GetMapping("/api/tutors")
    public Object tutors() {
        return tutorService.findAll();
    }

    @GetMapping("/api/bookings")
    public Object bookings() {
        return bookingService.findAll();
    }
}
