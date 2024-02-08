package com.example.Seminar_04.Homework.model;

import java.util.Arrays;

public class IP {
    private byte[] octets = new byte[4];

    @Override
    public String toString() {

        return octets[0] + "."+ octets[1] + "." + octets[2] + "." + octets[3];
    }
    public void getIP(byte[] octets){
        if (octets.length != 4){
            throw new RuntimeException("Недопустимая длина массива");
        }
        this.octets = octets;
    }
    public void getIP(int[] octets){
        if (octets.length != 4){
            throw new RuntimeException("Недопустимая длина массива");
        }
        for (int i = 0; i < octets.length; i++) {
            if (octets[i]>0 && octets[i]<256){
                this.octets[i] = (byte)octets[i];
            }else {
               throw new RuntimeException("Недопустимые значения в массиве" + octets);
            }

        }
    }
    public void getIP(String string){
        String[] octetsString = string.split(".");
        if (octetsString.length != 4){
            throw new RuntimeException("Недопустимая длина массива");
        }
        for (int i = 0; i < octetsString.length; i++) {
            []
        }

    }
}
