package net.ddns.wak.Java.Spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    public List<User> getAllUsers(){
        userRepository.save(new User(null, "Denis","saveliev.d@mail.ru"));
        userRepository.save(new User(null, "Artem","sadsfsdfsdsad@mail.ru"));
        userRepository.save(new User(null, "Igor","fsdfsdfsd@mail.ru"));
        return userRepository.findAll();
    }
    public User getUserById(Long id) {
        return userRepository.findById(id);
    }
}
