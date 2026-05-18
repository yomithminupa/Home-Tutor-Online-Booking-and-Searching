package com.example.hometutor.config;

import com.example.hometutor.model.AcademicSubject;
import com.example.hometutor.model.AdminUser;
import com.example.hometutor.model.Booking;
import com.example.hometutor.model.CardPayment;
import com.example.hometutor.model.CashPayment;
import com.example.hometutor.model.HomeVisitTutor;
import com.example.hometutor.model.OnlineTutor;
import com.example.hometutor.model.PublicReview;
import com.example.hometutor.model.StudentUser;
import com.example.hometutor.model.VerifiedReview;
import com.example.hometutor.repository.BookingRepository;
import com.example.hometutor.repository.PaymentRepository;
import com.example.hometutor.repository.ReviewRepository;
import com.example.hometutor.repository.SubjectRepository;
import com.example.hometutor.repository.TutorRepository;
import com.example.hometutor.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DataInitializer implements CommandLineRunner {
    private final UserRepository userRepository;
    private final TutorRepository tutorRepository;
    private final SubjectRepository subjectRepository;
    private final BookingRepository bookingRepository;
    private final PaymentRepository paymentRepository;
    private final ReviewRepository reviewRepository;

    public DataInitializer(UserRepository userRepository, TutorRepository tutorRepository,
                           SubjectRepository subjectRepository, BookingRepository bookingRepository,
                           PaymentRepository paymentRepository, ReviewRepository reviewRepository) {
        this.userRepository = userRepository;
        this.tutorRepository = tutorRepository;
        this.subjectRepository = subjectRepository;
        this.bookingRepository = bookingRepository;
        this.paymentRepository = paymentRepository;
        this.reviewRepository = reviewRepository;
    }

    @Override
    public void run(String... args) {
        saveUsers();
        saveTutors();
        saveSubjects();
        saveBookings();
        savePayments();
        saveReviews();
    }

    private void saveUsers() {
        userRepository.save(new StudentUser("U001", "Yomith de Silva", "yomith@gmail.com", "0742766335", "yomith123", "Grade 10", "Colombo"));
        userRepository.save(new StudentUser("U002", "Basilu Gunasekara", "basilu@google.com", "0786422652", "basilu123", "Grade 11", "Kandy"));
        userRepository.save(new AdminUser("A001", "Hiranthaadm", "hirantha@google.com", "0718084508", "hirantha123"));
    }

    private void saveTutors() {
        tutorRepository.save(new OnlineTutor("T001", "Ayesha Silva", "ayesha@google.com", "0703887435", "Mathematics", "BSc Mathematics", "Colombo", 3000.0, "Available", "Microsoft Teams"));
        tutorRepository.save(new HomeVisitTutor("T002", "Ruwan Jayasinghe", "ruwan@google.com", "0779156824", "Science", "BEd Science", "Kandy", 3600.0, "Weekends", 0.0));
        tutorRepository.save(new OnlineTutor("T003", "Tharindu Wijesinghe", "tharindu@google.com", "0743332211", "ICT", "BSc IT", "Galle", 3200.0, "Evenings", "Google Meet"));
    }

    private void saveSubjects() {
        List<String[]> subjects = List.of(
                new String[]{"S001", "English", "English", "Grade 10"},
                new String[]{"S002", "Sinhala", "English", "Grade 10"},
                new String[]{"S003", "Mathematics", "Sinhala", "Grade 10"},
                new String[]{"S004", "Science", "Sinhala", "Grade 9"},
                new String[]{"S005", "Music", "Sinhala", "Grade 11"},
                new String[]{"S006", "ICT", "English", "Grade 9"}
        );
        subjects.forEach(subject -> subjectRepository.save(new AcademicSubject(subject[0], subject[1], subject[3], subject[2])));
    }

    private void saveBookings() {
        bookingRepository.save(new Booking("B001", "U001", "T001", "Mathematics", "2026-05-10", "16:00", "Online", "PENDING", "ONLINE"));
        bookingRepository.save(new Booking("B002", "U002", "T002", "Science", "2026-05-12", "09:30", "Kandy", "APPROVED", "HOME_VISIT"));
        bookingRepository.save(new Booking("B015", "U001", "T002", "Mathematics", "2026-05-29", "15:07", "Colombo", "PENDING", "HOME_VISIT"));
        bookingRepository.save(new Booking("B016", "U002", "T002", "Science", "2026-05-22", "22:25", "Colombo", "APPROVED", "HOME_VISIT"));
    }

    private void savePayments() {
        paymentRepository.save(new CardPayment("P001", "B001", "U001", 3000.0, "2026-05-10", "PAID", "Yomith de Silva", "**** **** **** 1234", "AUTH001", "EduPay Gateway"));
        paymentRepository.save(new CashPayment("P002", "B002", "U002", 4600.0, "2026-05-12", "PENDING", "Ruwan Jayasinghe"));
    }

    private void saveReviews() {
        reviewRepository.save(new VerifiedReview("R001", "T001", "U001", 5, "Clear explanations and useful examples", "B001"));
        reviewRepository.save(new PublicReview("R002", "T002", "U002", 4, "Good home visit tutor for science", "Basilu"));
    }
}
