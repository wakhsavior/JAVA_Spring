package net.ddns.wakh.HomeWork.services;

import lombok.AllArgsConstructor;
import lombok.Getter;
import net.ddns.wakh.HomeWork.domain.User;
import net.ddns.wakh.HomeWork.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Getter
public class UserService {

    private UserRepository repository;
    public void addUser(User user){
       repository.saveUser(user);
    }
    public List<User> getAllUsers(){
        repository.saveUser(new User("Artur",23,"exam1@yandex.ru"));
        repository.saveUser(new User("Denis",34,"exam2@yandex.ru"));
        repository.saveUser(new User("Igor",28,"exam3@yandex.ru"));
        repository.saveUser(new User("Matvey",37,"exam4@yandex.ru"));
        return repository.getUsers();
    }
}
