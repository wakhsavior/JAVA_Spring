package net.ddns.wakh.HomeWork.services;

import lombok.AllArgsConstructor;
import net.ddns.wakh.HomeWork.domain.User;
import net.ddns.wakh.HomeWork.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class RegistrationService {
    private UserService userService;
    private NotificationService notificationService;
    private UserRepository repository;
    public void processRegistration(User user){
        repository.saveUser(user);
        notificationService.notifyUser("Save User: " + user);
    }
    public void processRegistration(String name,int age, String email){
        User user = new User(name,age,email);
        repository.saveUser(user);
        notificationService.notifyUser("Save User: " + user);
    }
}
