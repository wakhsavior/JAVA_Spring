package net.ddns.wak.Java.Spring.service;

import net.ddns.wak.Java.Spring.model.User;
import net.ddns.wak.Java.Spring.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }
    public User getUserById(Long id) {
        return userRepository.findById(id);
    }
    public void addUser(User user){
        userRepository.save(user);
    }
}
