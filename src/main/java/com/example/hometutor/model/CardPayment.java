//create package
package com.example.hometutor.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("CARD")
//create a class
public class CardPayment extends Payment{
   //attributes
   private String cardHolderName;
    private String maskedCardNumber;
    private String authorizationCode;
//create  default constructor
    public CardPayment() {
    }
//parameterize constructor
    public CardPayment(String id, String bookingId, String userId, double amount, String paymentDate, String status,
                       String cardHolderName, String maskedCardNumber, String authorizationCode) {
        super(id, bookingId, userId, amount, paymentDate, status);
        this.cardHolderName = cardHolderName;
        this.maskedCardNumber = maskedCardNumber;
        this.authorizationCode = authorizationCode;
    }
//getters setters ,method override,
    @Override
    public String getPaymentMethod() {

        return "Card Payment";
    }

    public String getCardHolderName() {

        return cardHolderName;
    }

    public void setCardHolderName(String cardHolderName) {

        this.cardHolderName = cardHolderName;
    }

    public String getMaskedCardNumber() {

        return maskedCardNumber;
    }

    public void setMaskedCardNumber(String maskedCardNumber) {

        this.maskedCardNumber = maskedCardNumber;
    }

    public String getAuthorizationCode() {

        return authorizationCode;
    }

    public void setAuthorizationCode(String authorizationCode) {

        this.authorizationCode = authorizationCode;
    }
}







































