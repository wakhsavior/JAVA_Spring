package my.spring.Homework_CRUD.controllers;


import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import my.spring.Homework_CRUD.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import my.spring.Homework_CRUD.services.UserService;

import java.util.List;
import java.util.logging.Level;


@Controller
@RequiredArgsConstructor
@Log
public class UserController {
    private final UserService userService;

    @GetMapping("/users")
    public String findAll(Model model) {
        List<User> users = userService.findAll();
        model.addAttribute("users", users);
        log.log(Level.INFO, "GET Request: User open page with users");
        return "user-list";
        //return "home.html";
    }

    @GetMapping("/user-create")
    public String createUserForm(User user) {
        log.log(Level.INFO, "GET Request: User request page to create new user");
        return "user-create";
    }

    @PostMapping("/user-create")
    public String createUser(User user) {
        userService.saveUser(user);
        log.log(Level.INFO, "POST Request:User create new user " +
                "{FirstName: " + user.getFirstName() +
                "; LastName: " + user.getLastName() + "}");
        return "redirect:/users";
    }

    @GetMapping("user-delete/{id}")
    public String deleteUser(@PathVariable("id") int id) {
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
        return "redirect:/users";
    }

    @GetMapping("user-update/{id}")
    public String updateUserForm(User user, @PathVariable("id") int id) {
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
    public String updateUser(User user) {
        System.out.println(user);
        userService.updateUser(user);
        log.log(Level.INFO, "GET Request: User update user" +
                "{id: " + user.getId() + "; FirstName: " + user.getFirstName() +
                "; LastName: " + user.getLastName() + "}");
        return "redirect:/users";
    }
}