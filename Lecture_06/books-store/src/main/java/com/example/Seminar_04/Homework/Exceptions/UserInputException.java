package com.example.Seminar_04.Homework.Exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@Getter
@ResponseStatus(value= HttpStatus.BAD_REQUEST, reason="Ошибка ввода")
public class UserInputException extends RuntimeException{
    private String string;
    public UserInputException(String string, String message) {
        super(string + message);
        this.string = string;
    }
}
