package ru.gb.Homework.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Контроллер обработки домашней страницы и перенаправления на /task
 */
@Controller
@RequestMapping({"/", ""})
public class BaseController {
    @GetMapping()
    public String getHomePage(){
        String result = "redirect:/tasks";
        return result;
    }
}
