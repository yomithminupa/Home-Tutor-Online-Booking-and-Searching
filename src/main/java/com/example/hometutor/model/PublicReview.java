//create a package
package com.example.hometutor.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

//create a class
public class PublicReview extends Review {
   //attributes
   private String nickname;
//default constructor
public PublicReview() {
}
//parametrize constructor
public PublicReview(String id, String tutorId, String userId, int rating, String comment, String nickname) {
    super(id, tutorId, userId, rating, comment);
    this.nickname = nickname;
}
//method overriding ,getters and setters
@Override
public String getReviewType() {

    return "PUBLIC";
}

    @Override
    public String displayReview() {

    return nickname + ": " + super.displayReview();
    }

    public String getNickname() {

    return nickname;
    }

    public void setNickname(String nickname) {

    this.nickname = nickname;
    }
}











