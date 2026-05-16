//create a package
package com.example.hometutor.repository;

import com.example.hometutor.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

//create a class
public interface PaymentRepository extends JpaRepository<Payment, String> {

}
