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


















}


























public class CardPayment {






}
