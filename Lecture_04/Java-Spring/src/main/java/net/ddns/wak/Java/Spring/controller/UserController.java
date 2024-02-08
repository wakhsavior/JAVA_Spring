package net.ddns.wak.Java.Spring.controller;

import net.ddns.wak.Java.Spring.model.User;
import net.ddns.wak.Java.Spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public String listUsers(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "users";
    }

    @GetMapping("/{id}")
    public String getUser(@PathVariable Long id, Model model) {
        model.addAttribute("user", userService.getUserById(id));
        return "userProfile";
    }

    @PostMapping()
    public String addUser(User user, Model model) {
        userService.addUser(user);
        List<User> users = userService.getAllUsers();
        model.addAttribute("users", userService.getAllUsers());
        return "users";
    }
}
