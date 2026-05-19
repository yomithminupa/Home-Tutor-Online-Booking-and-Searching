//create a  package
package com.example.hometutor.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("CASH")
//create a class
public class CashPayment extends Payment {
    //attributes
    private String collectedBy;
    private String receiptNumber;

    //default constructor
    public CashPayment() {
    }

    //parameterize constructor
    public CashPayment(String id, String bookingId, String userId, double amount, String paymentDate, String status,
                       String collectedBy, String receiptNumber) {
        super(id, bookingId, userId, amount, paymentDate, status);
        this.collectedBy = collectedBy;
        this.receiptNumber = receiptNumber;
    }

    //getters and setters , method overriding
    @Override
    public String getPaymentMethod() {

        return "Cash Payment";
    }

    public String getCollectedBy() {

        return collectedBy;
    }

    public void setCollectedBy(String collectedBy) {

        this.collectedBy = collectedBy;
    }

    public String getReceiptNumber() {

        return receiptNumber;
    }

    public void setReceiptNumber(String receiptNumber) {

        this.receiptNumber = receiptNumber;
    }
}
