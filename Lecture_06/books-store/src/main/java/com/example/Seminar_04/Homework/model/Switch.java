package com.example.Seminar_04.Homework.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;


@Data
@AllArgsConstructor
public class Switch {
    private Integer id ;
    private IP ipAddress;
//    private final IP ipDefGW;
//    private final IP netMask;
    private String hostname;
    private String model;
    private String vendor;
//    private final String serialNum;


    public String getIpAddress() {
        return ipAddress.toString();
    }
    public void setIpAddress(String ip){
        ipAddress = IP.createIP(ip);
    }
    public void setIpAddress(IP ip){
        ipAddress = ip;
    }
}
