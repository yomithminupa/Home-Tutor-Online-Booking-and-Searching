//create a package
package com.example.hometutor.repository;

import com.example.hometutor.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;

//create a class
public interface ReviewRepository extends JpaRepository<Review, String> {
}
