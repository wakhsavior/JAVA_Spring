package com.example.Seminar_04.Homework.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@AllArgsConstructor
@RequestMapping
public class UserController {
    @GetMapping()
    public String welcome(){
        return "index.html";
    }
    @GetMapping("/about")
    public String about(){
        return "about.html";
    }

}
