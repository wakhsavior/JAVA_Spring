package com.example.Seminar_04.Homework.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class Switch {
    IP ipAddress;
    IP ipDefGW;
    String hostname;
    String model;
    String vendor;
    String serialNum;

}
