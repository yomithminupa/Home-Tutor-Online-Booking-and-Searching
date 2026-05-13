package com.example.hometutor.controller;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.ui.Model;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({
            IllegalArgumentException.class,
            MissingServletRequestParameterException.class,
            DataIntegrityViolationException.class
    })
    public String handleUserInputError(Exception exception, Model model) {
        model.addAttribute("title", "Request could not be completed");
        model.addAttribute("message", cleanMessage(exception));
        return "error";
    }

    @ExceptionHandler(Exception.class)
    public String handleUnexpectedError(Exception exception, Model model) {
        model.addAttribute("title", "Something went wrong");
        model.addAttribute("message", cleanMessage(exception));
        return "error";
    }

    private String cleanMessage(Exception exception) {
        String message = exception.getMessage();
        if (message == null || message.isBlank()) {
            return "Please check the form details and try again.";
        }
        return message;
    }
}
