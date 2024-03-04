package ru.gb.MySpringSecurity.services;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.gb.MySpringSecurity.model.Application;
import ru.gb.MySpringSecurity.model.User;
import ru.gb.MySpringSecurity.repositories.AppRepo;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AppService {
    private final AppRepo appRepo;
    public void loadDatainDB(){
        appRepo.loadDatainDB();
    }
    public List<Application> allApplications(){
        return appRepo.allApplications();
    }
    public Application applicationById(int id){
        return appRepo.applicationById(id);
    }
    public void addUser (User user){
        appRepo.addUser(user);
    }
    public List<User> getAllUsers(){
        return appRepo.getAllUser();
    }
}
