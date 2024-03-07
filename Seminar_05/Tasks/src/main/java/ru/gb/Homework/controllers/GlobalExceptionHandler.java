package ru.gb.Homework.controllers;

import lombok.extern.java.Log;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import ru.gb.Homework.Exceptions.TaskNotFoundException;

import java.util.logging.Level;

@ControllerAdvice
@Log
public class GlobalExceptionHandler {
    @ExceptionHandler(TaskNotFoundException.class)
    public String conflict() {
        log.log(Level.WARNING, "Task not found exception occur");
        return "redirect:/tasks";
    }
}