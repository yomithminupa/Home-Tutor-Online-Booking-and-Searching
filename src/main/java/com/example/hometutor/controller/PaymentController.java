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
public class PaymentController {
    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @GetMapping
    public String list(@RequestParam(required = false) String keyword, Model model) {
        model.addAttribute("payments", paymentService.search(keyword));
        model.addAttribute("keyword", keyword == null ? "" : keyword);
        return "payments";
    }

    @GetMapping("/new")
    public String newForm() {
        return "payment-form";
    }

    @PostMapping
    public String create(@RequestParam String id, @RequestParam String bookingId, @RequestParam String userId,
                         @RequestParam double amount, @RequestParam String paymentDate,
                         @RequestParam String status, @RequestParam String paymentType,
                         @RequestParam(required = false, defaultValue = "") String cardHolderName,
                         @RequestParam(required = false, defaultValue = "") String maskedCardNumber,
                         @RequestParam(required = false, defaultValue = "") String authorizationCode,
                         @RequestParam(required = false, defaultValue = "") String collectedBy,
                         @RequestParam(required = false, defaultValue = "") String receiptNumber) {
        Payment payment = paymentService.buildPayment(id, bookingId, userId, amount, paymentDate, status, paymentType,
                cardHolderName, maskedCardNumber, authorizationCode, collectedBy, receiptNumber);
        paymentService.create(payment);
        return "redirect:/payments";
    }

    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable String id, Model model) {
        model.addAttribute("payment", paymentService.findById(id).orElse(null));
        return "payment-form";
    }

    @PostMapping("/edit/{id}")
    public String update(@PathVariable String id, @RequestParam String bookingId, @RequestParam String userId,
                         @RequestParam double amount, @RequestParam String paymentDate,
                         @RequestParam String status, @RequestParam String paymentType,
                         @RequestParam(required = false, defaultValue = "") String cardHolderName,
                         @RequestParam(required = false, defaultValue = "") String maskedCardNumber,
                         @RequestParam(required = false, defaultValue = "") String authorizationCode,
                         @RequestParam(required = false, defaultValue = "") String collectedBy,
                         @RequestParam(required = false, defaultValue = "") String receiptNumber) {
        Payment payment = paymentService.buildPayment(id, bookingId, userId, amount, paymentDate, status, paymentType,
                cardHolderName, maskedCardNumber, authorizationCode, collectedBy, receiptNumber);
        paymentService.update(payment);
        return "redirect:/payments";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable String id) {
        paymentService.delete(id);
        return "redirect:/payments";
    }
}
