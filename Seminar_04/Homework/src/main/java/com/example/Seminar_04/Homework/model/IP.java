package com.example.Seminar_04.Homework.model;

import com.example.Seminar_04.Homework.Exceptions.UserInputException;
import lombok.Data;

import java.util.Arrays;
@Data
public class IP {
    private int intIP;

    public static IP createIP(String s) {
        IP ip = new IP();
        ip.setIP(s);
        return ip;
    }

    public static IP createIP(int intIP) {
        IP ip = new IP();
        ip.setIP(intIP);
        return ip;
    }
    public IP(String ip){
        setIP(ip);
    }
    public IP(){

    }


    public void setIP(int intIP) {
        this.intIP = intIP;
    }

    public void setIP(String string) {
        string = string.strip();
        String[] octetsString = string.split("\\.");
        if (octetsString.length != Integer.BYTES) {
            throw new UserInputException("Недопустимая длина массива: ", String.valueOf(octetsString.length));
        }
        for (int i = 0; i < octetsString.length; i++) {
            int octet = Integer.parseInt(octetsString[i]);
            if (octet < 0 || octet > 255) {
                throw new UserInputException("Недопустимое значение в массиве: ", octetsString[i]);
            }
            intIP = intIP + (octet << (Byte.SIZE * (Integer.BYTES - i - 1)));

        }
    }

    @Override
    public String toString() {
        StringBuilder stringIP = new StringBuilder();

        for (int i = 0; i < Integer.BYTES; i++) {
            stringIP.append(Integer.toString(intIP << (Byte.SIZE * i) >>> (Byte.SIZE * (Integer.BYTES - 1))));
            stringIP.append(".");
        }
        stringIP.deleteCharAt(stringIP.length() - 1);
        return stringIP.toString();
    }
}
