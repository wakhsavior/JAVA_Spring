package net.ddns.wakh.HomeWork.services;

import lombok.AllArgsConstructor;
import net.ddns.wakh.HomeWork.domain.User;
import net.ddns.wakh.HomeWork.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Класс регистрации новых пользователей и внесения изменений в существующих
 */
@Service
@AllArgsConstructor
public class RegistrationService {
    private NotificationService notificationService;
    private UserRepository repository;

    /**
     * Метод получает сформированный объект пользователя и сохраняет его в репозиторий
     * @param user Пользователь
     */
    public void processRegistration(User user){
        repository.saveUser(user);
        notificationService.notifyUser("Save User: " + user);
    }

    /**
     * Метод получает данные пользователя Имя, Возраст, Электронная почта, создает объект
     * и сохраняет его в репозиторий
     * @param name Имя
     * @param age Возраст
     * @param email Электронная почта
     */
    public void processRegistration(String name,int age, String email){
        User user = new User(name,age,email);
        repository.saveUser(user);
        notificationService.notifyUser("Save User: " + user);
    }
}
