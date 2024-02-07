package net.ddns.wakh.HomeWork.controllers;

import lombok.AllArgsConstructor;
import lombok.Getter;
import net.ddns.wakh.HomeWork.domain.User;
import net.ddns.wakh.HomeWork.services.DataProcessingService;
import net.ddns.wakh.HomeWork.services.RegistrationService;
import net.ddns.wakh.HomeWork.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * REST Контроллер обращения к странице пользователя /user
 */
@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UserController {
    DataProcessingService dataProcessingService;
    RegistrationService registrationService;
    @GetMapping()
    public List<User> users(){
        return (dataProcessingService.getAllUsers());
    }
    @PostMapping()
    public void addUserPost(@RequestBody User user){
        registrationService.processRegistration(user);
//        return user.toString();
    }
    @GetMapping("/user")
    public void addUserGet(@RequestParam(name = "name") String name,
                             @RequestParam(name = "age") int age,
                             @RequestParam(name = "email") String email){
        registrationService.processRegistration(name, age, email);
//    return user.toString();
    }

}
