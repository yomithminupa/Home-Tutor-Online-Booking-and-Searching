package com.example.hometutor.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("CASH")
public class CashPayment extends Payment {
    private String collectedBy;
    private String receiptNumber;

    public CashPayment() {
    }

    public CashPayment(String id, String bookingId, String userId, double amount, String paymentDate, String status,
                       String collectedBy, String receiptNumber) {
        super(id, bookingId, userId, amount, paymentDate, status);
        this.collectedBy = collectedBy;
        this.receiptNumber = receiptNumber;
    }

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
