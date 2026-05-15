//create a package
package com.example.hometutor.controller;

import com.example.hometutor.model.Payment;
import com.example.hometutor.service.PaymentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/payments")
//create a class
public class PaymentController {
//attribute
private final PaymentService paymentService;
//constructor
public PaymentController(PaymentService paymentService) {
    this.paymentService = paymentService;
}






}












}
