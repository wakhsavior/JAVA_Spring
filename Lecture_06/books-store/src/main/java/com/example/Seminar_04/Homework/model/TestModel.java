package com.example.Seminar_04.Homework.model;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.InetSocketAddress;

public class TestModel {
    public static void main(String[] args) {

        IP ip1 = IP.createIP("192.168.10.1");
        System.out.println(ip1);
//        IP ip2 = IP.createIP("192.168.10");
//        System.out.println(ip2);
//        IP ip3 = IP.createIP("192.168.10.");
//        System.out.println(ip3);
//        IP ip4 = IP.createIP("192.257.32.4");
//        System.out.println(ip4);
        IP ip5 = IP.createIP("1dsfsadfsdf");
        System.out.println(ip5);
    }
}
