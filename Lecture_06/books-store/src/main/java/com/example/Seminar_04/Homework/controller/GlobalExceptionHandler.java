package com.example.Seminar_04.Homework.controller;

import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public String conflict() {
        System.out.println("Exception occur");// Nothing to do
        return "redirect:/switches.html";
    }
}
