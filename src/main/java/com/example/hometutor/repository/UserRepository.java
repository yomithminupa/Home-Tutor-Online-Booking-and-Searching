// It provides built-in CRUD operations using Spring Data JPA,use it data access layer for User entity.

package com.example.hometutor.repository;

import com.example.hometutor.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
}
