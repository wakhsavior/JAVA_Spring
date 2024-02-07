package net.ddns.wakh.HomeWork.controllers;

import lombok.AllArgsConstructor;
import net.ddns.wakh.HomeWork.domain.User;
import net.ddns.wakh.HomeWork.services.DataProcessingService;
import net.ddns.wakh.HomeWork.services.RegistrationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST Контроллер обращения к странице пользователя /users
 * Заполнение с использованием Lombok
 */
@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UserController {
    DataProcessingService dataProcessingService;
    RegistrationService registrationService;

    /**
     * GET запрос на получение списка всех пользователей, выводит
     * в виде JSON в ответ на запрос
     * @return List<User>
     */
    @GetMapping()
    public List<User> users(){
        return (dataProcessingService.getAllUsers());
    }

    /**
     * POST Запрос на добавление пользователя, передать пользователя в JSON виде в теле запроса
     * в запрос включить name, age, email
     * {
     * "name":"Artur",
     * "age":23,
     * "email":"exam1@yandex.ru"
     * }
     * @param user
     */
    @PostMapping()
    public void addUserPost(@RequestBody User user){
        registrationService.processRegistration(user);
//        return user.toString();
    }

    /**
     * GET запрос на добавления пользователя по адресу /users/user?name=name&age=age&email=mail
     * @param name
     * @param age
     * @param email
     */
    @GetMapping("/user")
    public void addUserGet(@RequestParam(name = "name") String name,
                             @RequestParam(name = "age") int age,
                             @RequestParam(name = "email") String email){
        registrationService.processRegistration(name, age, email);
//    return user.toString();
    }

}
