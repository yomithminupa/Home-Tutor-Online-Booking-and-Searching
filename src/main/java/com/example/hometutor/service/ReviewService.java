//create package
package com.example.hometutor.service;

import com.example.hometutor.model.PublicReview;
import com.example.hometutor.model.Review;
import com.example.hometutor.model.VerifiedReview;
import com.example.hometutor.repository.ReviewRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;

@Service
//create a class
public class ReviewService extends AbstractCrudService<Review> {
//parameterize constructor
public ReviewService(ReviewRepository reviewRepository) {

    super(reviewRepository);
}
//method
    public Review buildReview(String type, String id, String tutorId, String userId, int rating,
                              String comment, String nickname, String bookingId) {
        if ("VERIFIED".equalsIgnoreCase(type)) {
            return new VerifiedReview(id, tutorId, userId, rating, comment, bookingId);
        }
        return new PublicReview(id, tutorId, userId, rating, comment, nickname);
    }
    //method overriding'l
    @Override
    public List<Review> search(String keyword) {
        if (keyword == null || keyword.isBlank()) {
            return findAll();
        }
        String query = keyword.toLowerCase(Locale.ROOT);
        return findAll().stream()
                .filter(review -> contains(review.getId(), query)
                        || contains(review.getTutorId(), query)
                        || contains(review.getUserId(), query)
                        || contains(review.getComment(), query)
                        || contains(review.getReviewType(), query))
                .toList();
    }
//method
    private static boolean contains(String value, String query) {
        return value != null && value.toLowerCase(Locale.ROOT).contains(query);
    }
}












}