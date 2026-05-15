package com.example.hometutor.repository;
 
import com.example.hometutor.model.Tutor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TutorRepository extends JpaRepository<Tutor, String> {
}
