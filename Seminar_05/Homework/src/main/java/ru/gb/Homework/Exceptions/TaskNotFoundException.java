package ru.gb.Homework.Exceptions;

import lombok.AllArgsConstructor;


public class TaskNotFoundException extends Exception{
    private Long id;
    public TaskNotFoundException(String message,Long id){
        super(message);
        this.id = id;

    }

}
