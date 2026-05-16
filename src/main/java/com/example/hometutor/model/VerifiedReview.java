//create a package
package com.example.hometutor.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("VERIFIED")

//create a class
public class VerifiedReview extends Review {
    //attributes
    private String bookingId;
 //default constructor
 public VerifiedReview() {
 }
    //parameterize constructor
    public VerifiedReview(String id, String tutorId, String userId, int rating, String comment, String bookingId) {
        super(id, tutorId, userId, rating, comment);
        this.bookingId = bookingId;
    }
    //method overriding and getters and setters
    @Override
    public String getReviewType() {

     return "VERIFIED";
    }

    @Override
    public String displayReview() {

     return "Verified booking " + bookingId + ": " + super.displayReview();
    }

    public String getBookingId() {

     return bookingId;
    }

    public void setBookingId(String bookingId) {

     this.bookingId = bookingId;
    }
}
