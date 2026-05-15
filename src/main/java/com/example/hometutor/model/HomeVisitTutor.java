package com.example.hometutor.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("HOME_VISIT")
public class HomeVisitTutor extends Tutor {
    private double travelFee;

    public HomeVisitTutor() {
    }

    public HomeVisitTutor(String id, String name, String email, String phone, String subject,
                          String qualification, String location, double hourlyRate, String availability,
                          double travelFee) {
        super(id, name, email, phone, subject, qualification, location, hourlyRate, availability);
        this.travelFee = travelFee;
    }

    @Override
    public String getTutorType() {
        return "HOME_VISIT";
    }

    @Override
    public double calculateSessionFee(int hours) {
        return (getHourlyRate() * hours) + travelFee;
    }

    @Override
    public String displayCard() {
        return super.displayCard() + " as a home visit tutor";
    }

    public double getTravelFee() {
        return travelFee;
    }

    public void setTravelFee(double travelFee) {
        this.travelFee = travelFee;
    }
}
