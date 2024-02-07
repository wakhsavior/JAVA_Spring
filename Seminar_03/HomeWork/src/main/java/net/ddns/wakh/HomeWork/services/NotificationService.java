package net.ddns.wakh.HomeWork.services;

import net.ddns.wakh.HomeWork.domain.User;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Класс оповещения о событиях
 */
@Service
public class NotificationService {
    /**
     * Метод получает сообщение и со временем выводит в консоль
     * @param message Переданное сообщение для вывода
     */
    public void notifyUser(String message){
        Date date =new Date();
        System.out.println(date.toString() + " : " + message);
    }
}
