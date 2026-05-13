package com.example.hometutor.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("PUBLIC")
public class PublicReview extends Review {
    private String nickname;

    public PublicReview() {
    }

    public PublicReview(String id, String tutorId, String userId, int rating, String comment, String nickname) {
        super(id, tutorId, userId, rating, comment);
        this.nickname = nickname;
    }

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
