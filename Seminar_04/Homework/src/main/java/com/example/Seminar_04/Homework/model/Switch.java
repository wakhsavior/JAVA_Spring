package com.example.Seminar_04.Homework.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;


@Data
public class Switch {
    private final int id ;
    private IP ipAddress;
//    private final IP ipDefGW;
//    private final IP netMask;
    private String hostname;
    private String model;
    private String vendor;
//    private final String serialNum;

    public Switch(int id) {
        this.id = id;
    }
}
