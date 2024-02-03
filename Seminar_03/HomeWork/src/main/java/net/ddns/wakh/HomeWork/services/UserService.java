package net.ddns.wakh.HomeWork.services;

import net.ddns.wakh.HomeWork.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private NotificationService notificationService;

//    public UserService(NotificationService notificationService) {
//        this.notificationService = notificationService;
//    }
    public User createUser(String name, int age, String email){
       User user = new User();
       user.setName(name);
       user.setAge(age);
       user.setEmail(email);
       return user;
    }
}
