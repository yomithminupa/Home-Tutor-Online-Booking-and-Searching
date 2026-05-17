//create a package
package com.example.hometutor.service;

import com.example.hometutor.model.CardPayment;
import com.example.hometutor.model.CashPayment;
import com.example.hometutor.model.Payment;
import com.example.hometutor.repository.PaymentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;

@Service
//create a class
public class PaymentService extends AbstractCrudService<Payment> {

    //method
    public Payment buildPayment(String id, String bookingId, String userId, double amount, String paymentDate,
                                String status, String paymentType, String cardHolderName, String maskedCardNumber,
                                String authorizationCode, String collectedBy, String receiptNumber) {
        if ("CASH".equalsIgnoreCase(paymentType)) {
            return new CashPayment(id, bookingId, userId, amount, paymentDate, status, collectedBy, receiptNumber);
        }
        return new CardPayment(id, bookingId, userId, amount, paymentDate, status,
                cardHolderName, maskedCardNumber, authorizationCode);
    }











}