package com.example.hometutor.service;

import com.example.hometutor.model.AcademicSubject;
import com.example.hometutor.model.SkillSubject;
import com.example.hometutor.model.Subject;
import com.example.hometutor.repository.SubjectRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;

@Service
public class SubjectService extends AbstractCrudService<Subject> {

    public SubjectService(SubjectRepository subjectRepository) {
        super(subjectRepository);
    }
    // Build subject object according to category
    public Subject buildSubject(String category, String id, String name, String gradeLevel,
                                String description, String stream, String skillLevel) {
        if ("SKILL".equalsIgnoreCase(category)) {
            return new SkillSubject(id, name, gradeLevel, description, skillLevel);
        }
        // Otherwise create AcademicSubject object
        return new AcademicSubject(id, name, gradeLevel, description, stream);
    }

    @Override
    public List<Subject> search(String keyword) {
        if (keyword == null || keyword.isBlank()) {
            return findAll();
        }
        String query = keyword.toLowerCase(Locale.ROOT);
        return findAll().stream()
                .filter(subject -> contains(subject.getId(), query)
                        || contains(subject.getName(), query)
                        || contains(subject.getGradeLevel(), query)
                        || contains(subject.getCategory(), query))
                .toList();
    }

    private static boolean contains(String value, String query) {
        return value != null && value.toLowerCase(Locale.ROOT).contains(query);
    }
}
