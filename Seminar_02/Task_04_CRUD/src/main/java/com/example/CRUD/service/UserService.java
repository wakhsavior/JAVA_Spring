package com.example.CRUD.service;

import com.example.CRUD.repositories.UserRepository;
import org.springframework.stereotype.Service;
import com.example.CRUD.model.*;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }
    public List<User> findAll(){
        return userRepository.findAll();
    }
    public User saveUser(User user){
        return userRepository.save(user);
    }

}
