package ru.gb.MySpringSecurity.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import ru.gb.MySpringSecurity.model.Application;
import ru.gb.MySpringSecurity.model.Authority;
import ru.gb.MySpringSecurity.model.User;
import ru.gb.MySpringSecurity.services.AppService;

import java.io.IOException;
import java.io.StringWriter;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class AppController {
    private final AppService appService;

    /**
     * Доступ открыт всем без авторизации
     * @return
     */
    @GetMapping("/welcome")
    public String welcome() {
        return "welcome to unprotected page";
    }

    /**
     * Прослушивает /api/all-app и Выводит все приложения, доступно для пользователей с ролью ROLE_USER
     * @return
     */
    @GetMapping("/all-app")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public List<Application> allApplication() {
        System.out.println("Hello all Apps");
        return appService.allApplications();
    }

    /**
     * Прослушивает /api/{id} Выводит приложение по ID доступно только пользователям с ролью ROLE_ADMIN
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public Application applicationById(@PathVariable("id") int id) {
        return appService.applicationById(id);
    }

    /**
     * Слушает POST запросы на /api/new-user и считывает из BODY JSON на создание пользователя. Формат JSON
     * {"username":"user","password":"password123","authorities":[{"name":"ROLE_USER"}]}
     * В списке можно указать несколько ролей через запятую
     * @param user
     * @return
     */
    @PostMapping("/new-user")
    @ResponseStatus(HttpStatus.CREATED)
    public String addUser(@RequestBody User user) {
        System.out.println(user);
        user.getAuthorities().stream().map(a -> a.getName()).forEach(System.out::println);
        appService.addUser(user);
        return "User is saved: {" + user + "}";
    }

    /**
     * Mapping прослущивает GET запросы на /api/new-user и создает пользователя в базе с 2-мя ролями
     * таж-же выводит в консоль JSON формат
     * @return
     * @throws IOException
     */

    @GetMapping("/new-user")
    @ResponseStatus(HttpStatus.CREATED)
    public String addUser() throws IOException {
        User user = new User();
        Authority authority1 = new Authority();
        Authority authority2 = new Authority();
        authority1.setName("ROLE_ADMIN");
        authority2.setName("ROLE_USER");
        user.setUsername("administrator");
        user.setPassword("password123");
        user.setAuthorities(List.of(authority1, authority2));
        StringWriter writer = new StringWriter();
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(writer, user);
        System.out.println(writer.toString());
        appService.addUser(user);
        System.out.println("Enter to create user");
        return "You do not create user, use Post Request";
    }
}
