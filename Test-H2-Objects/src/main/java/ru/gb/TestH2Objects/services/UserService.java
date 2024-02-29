package ru.gb.TestH2Objects.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.gb.TestH2Objects.model.User;
import ru.gb.TestH2Objects.repositories.UserRepo;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

@Service
@RequiredArgsConstructor
public class UserService {
    private List<User> users = new ArrayList<>();
    private final UserRepo userRepo;
    public void addUser(User user){
        userRepo.save(user);
        users.add(user);
    }
    public List<User> showAllUser(){
//        return users;
        return userRepo.findAll();
    }
    public User showUserByID(Integer id){
        Supplier<RuntimeException> supplier = () -> new RuntimeException("User not found");
        return userRepo.findById(id).orElseThrow(supplier);
    }
}
