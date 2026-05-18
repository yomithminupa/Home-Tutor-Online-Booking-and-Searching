package com.example.hometutor.service;

import com.example.hometutor.model.HomeVisitTutor;
import com.example.hometutor.model.OnlineTutor;
import com.example.hometutor.model.Tutor;
import com.example.hometutor.repository.TutorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;

@Service
public class TutorService extends AbstractCrudService<Tutor> {

    public TutorService(TutorRepository tutorRepository) {
        super(tutorRepository);
    }

    public Tutor buildTutor(String type, String id, String name, String email, String phone, String subject,
                            String qualification, String location, double hourlyRate, String availability,
                            String platform, double travelFee) {
        if ("HOME_VISIT".equalsIgnoreCase(type)) {
            return new HomeVisitTutor(id, name, email, phone, subject, qualification, location, hourlyRate, availability, travelFee);
        }
        return new OnlineTutor(id, name, email, phone, subject, qualification, location, hourlyRate, availability, platform);
    }

    @Override
    public List<Tutor> search(String keyword) {
        if (keyword == null || keyword.isBlank()) {
            return findAll();
        }
        String query = keyword.toLowerCase(Locale.ROOT);
        return findAll().stream()
                .filter(tutor -> contains(tutor.getId(), query)
                        || contains(tutor.getName(), query)
                        || contains(tutor.getSubject(), query)
                        || contains(tutor.getLocation(), query)
                        || contains(tutor.getAvailability(), query)
                        || contains(tutor.getTutorType(), query))
                .toList();
    }

    private static boolean contains(String value, String query) {
        return value != null && value.toLowerCase(Locale.ROOT).contains(query);
    }
}
