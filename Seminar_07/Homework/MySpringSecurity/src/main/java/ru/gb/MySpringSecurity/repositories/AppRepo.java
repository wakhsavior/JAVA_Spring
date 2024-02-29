package ru.gb.MySpringSecurity.repositories;

import com.github.javafaker.Faker;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;
import ru.gb.MySpringSecurity.model.Application;
import ru.gb.MySpringSecurity.model.User;

import java.util.List;
import java.util.stream.IntStream;

@Repository
@RequiredArgsConstructor
public class AppRepo {
    private final UserRepo userRepo;
    private List<Application> applications;
    /**
     * Необходим для шифрования пароля перед сохранением
     */
    private final PasswordEncoder passwordEncoder;

    @PostConstruct
    public void loadDatainDB() {
        Faker faker = new Faker();
        applications = IntStream.rangeClosed(1, 100)
                .mapToObj(i -> Application.builder()
                        .id(i)
                        .name(faker.app().name())
                        .author(faker.app().author())
                        .version(faker.app().version())
                        .build()).toList();
    }

    public List<Application> allApplications() {
        return applications;
    }

    public Application applicationById(int id) {
        return applications.stream().filter(app -> app.getId() == id)
                .findFirst()
                .orElse(null);
    }

    /**
     * Сохраняем пользователя предварительно зашифровав пароль
     * @param user
     */
    public void addUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepo.save(user);
    }
    public List<User> getAllUser(){
        return userRepo.findAll();
    }

}
