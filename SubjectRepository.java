package com.example.hometutor.repository;

import com.example.hometutor.model.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectRepository extends JpaRepository<Subject, String> {
  // Find subjects by name
    List<Subject> findByName(String name);
}
