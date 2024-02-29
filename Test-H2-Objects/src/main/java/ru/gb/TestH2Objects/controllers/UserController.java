package ru.gb.TestH2Objects.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.gb.TestH2Objects.model.User;
import ru.gb.TestH2Objects.services.UserService;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    @GetMapping("/show-users")
    public List<User> showAllUsers(){
        return userService.showAllUser();
    }
    @GetMapping("/show-user/{id}")
    public User showUserById(@PathVariable("id") Integer id){
        return userService.showUserByID(id);
    }
    @PostMapping("/add-user")
    public String addUser(@RequestBody User user){
        userService.addUser(user);
        return "User succesfully added:  " + user;
    }

}
