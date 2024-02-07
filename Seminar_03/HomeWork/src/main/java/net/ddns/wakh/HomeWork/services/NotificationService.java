package net.ddns.wakh.HomeWork.services;

import net.ddns.wakh.HomeWork.domain.User;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class NotificationService {
    public void notifyUser(String message){
        Date date =new Date();
        System.out.println(date.toString() + " : " + message);
    }
}
