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
public class DataProcessingService {
    private UserRepository userRepository;

    public List<User> getAllUsers(){
        userRepository.saveUser(new User("Artur",23,"exam1@yandex.ru"));
        userRepository.saveUser(new User("Denis",34,"exam2@yandex.ru"));
        userRepository.saveUser(new User("Igor",28,"exam3@yandex.ru"));
        userRepository.saveUser(new User("Matvey",37,"exam4@yandex.ru"));
        return userRepository.getUsers();
    }
    public List<User> sortUserByName() {
        return userRepository.getUsers()
                .stream()
                .sorted((o1, o2) -> o1.getName().compareTo(o2.getName()))
                .toList();
    }

    public List<User> filterUserByAge(int min, int max) {
        return userRepository.getUsers()
                .stream().filter(o -> o.getAge() > min && o.getAge() < max)
                .toList();
    }

    public double calculateAverageAge() {
        return userRepository.getUsers().stream()
                .mapToDouble(User::getAge).average().getAsDouble();
    }
}
