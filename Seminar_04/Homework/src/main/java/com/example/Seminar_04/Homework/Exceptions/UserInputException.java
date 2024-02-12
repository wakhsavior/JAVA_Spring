package com.example.Seminar_04.Homework.Exceptions;

import lombok.Getter;

@Getter
public class UserInputException extends RuntimeException{
    private String string;
    public UserInputException(String string, String message) {
        super(string + message);
        this.string = string;
    }
}
