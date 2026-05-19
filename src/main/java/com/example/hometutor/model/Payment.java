//create package
package com.example.hometutor.model;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;

@Entity
@Table(name = "payments")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "payment_type", discriminatorType = DiscriminatorType.STRING)
//create a class
public abstract class Payment implements IdentifiableEntity {
    //attributes
    @Id
    private String id;

    @Column(nullable = false)
    private String bookingId;

    @Column(nullable = false)
    private String userId;

    private double amount;
    private String paymentDate;
    private String status;
    //default constructor

    protected Payment() {
    }

    //parameterize constructor
    protected Payment(String id, String bookingId, String userId, double amount, String paymentDate, String status) {
        this.id = id;
        this.bookingId = bookingId;
        this.userId = userId;
        this.amount = amount;
        this.paymentDate = paymentDate;
        this.status = status;
    }

    //methods
    public abstract String getPaymentMethod();

    public String getReceiptSummary() {
        return getPaymentMethod() + " payment of Rs. " + amount + " for booking " + bookingId;
    }

    //getters and setters methods overriding
    @Override
    public String getId() {

        return id;
    }

    public void setId(String id) {

        this.id = id;
    }

    public String getBookingId() {

        return bookingId;
    }

    public void setBookingId(String bookingId) {

        this.bookingId = bookingId;
    }

    public String getUserId() {

        return userId;
    }

    public void setUserId(String userId) {

        this.userId = userId;
    }

    public double getAmount() {

        return amount;
    }

    public void setAmount(double amount) {

        this.amount = amount;
    }

    public String getPaymentDate() {

        return paymentDate;
    }

    public void setPaymentDate(String paymentDate) {

        this.paymentDate = paymentDate;
    }

    public String getStatus() {

        return status;
    }

}
