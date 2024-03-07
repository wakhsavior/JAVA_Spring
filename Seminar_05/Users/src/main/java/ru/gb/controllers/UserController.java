package ru.gb.controllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.gb.domain.User;
import ru.gb.services.UserService;
import java.util.logging.Level;


@Controller
@RequiredArgsConstructor
@Log
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    @GetMapping("")
    public String findAll(Model model) {
        model.addAttribute("users", userService.findAll());
        log.log(Level.INFO, "GET Request: User open page with users");
        return "user-list";
    }

    @GetMapping("/user-create")
    public String createUserForm(User user) {
        log.log(Level.INFO, "GET Request: User request page to create new user");
        return "user-create";
    }

    @PostMapping("/user-create")
    public String createUser(User user, Model model) {
        userService.saveUser(user);
        log.log(Level.INFO, "POST Request:User create new user " +
                "{FirstName: " + user.getFirstName() +
                "; LastName: " + user.getLastName() + "}");
        return findAll(model);
    }

    @GetMapping("user-delete/{id}")
    public String deleteUser(Model model, @PathVariable("id") int id) {
        if (userService.getUserById(id).isPresent()) {
            User user;
            user = userService.getUserById(id).get();
            log.log(Level.INFO, "GET Request: User delete user " +
                    "{id: " + id + "; FirstName: " + user.getFirstName() +
                    "; LastName: " + user.getLastName() + "}");
            userService.deleteUser(id);
        } else {
            log.log(Level.INFO, "GET Request: User with id " + id + " not found");
        }
        return findAll(model);
    }

    @GetMapping("user-update/{id}")
    public String updateUserForm(Model model, User user, @PathVariable("id") int id) {
        if (userService.getUserById(id).isPresent()) {
            user = userService.getUserById(id).get();
            log.log(Level.INFO, "GET Request: User update user " +
                    "{id: " + id + "; FirstName: " + user.getFirstName() +
                    "; LastName: " + user.getLastName() + "}");
        } else {
            log.log(Level.INFO, "GET Request: User with id " + id + " not found");
        }
        return "user-update";
    }

    @PostMapping("user-update")
    public String updateUser(Model model, User user) {
        System.out.println(user);
        userService.updateUser(user);
        log.log(Level.INFO, "GET Request: User update user" +
                "{id: " + user.getId() + "; FirstName: " + user.getFirstName() +
                "; LastName: " + user.getLastName() + "}");
        return findAll(model);
    }
}