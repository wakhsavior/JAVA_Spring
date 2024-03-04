package ru.gb.TestH2Objects.controllers;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Metrics;
import io.micrometer.core.instrument.step.StepCounter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.gb.TestH2Objects.model.User;
import ru.gb.TestH2Objects.services.UserService;

import java.util.List;
import java.util.zip.CheckedOutputStream;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    private final Counter showUsersCount = Metrics.counter("ShowUsersConuter");
    private final Counter createUserCount = Metrics.counter("CreateUserConter");
    @GetMapping("/show-users")
    public List<User> showAllUsers(){
        showUsersCount.increment();
        return userService.showAllUser();
    }
    @GetMapping("/show-user/{id}")
    public User showUserById(@PathVariable("id") Integer id){
        return userService.showUserByID(id);
    }
    @PostMapping("/add-user")
    public String addUser(@RequestBody User user){
        userService.addUser(user);
        createUserCount.increment();
        return "User succesfully added:  " + user;
    }

}
