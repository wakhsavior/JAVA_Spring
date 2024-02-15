package com.example.Seminar_04.Homework.controller;

import com.example.Seminar_04.Homework.repository.SwitchRepository;
import com.example.Seminar_04.Homework.services.SwitchService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.*;

@Controller
@RequestMapping
@RequiredArgsConstructor
public class UserController {
    private final SwitchService switchService;

    @GetMapping({"", "/", "main_tmpl.html"})
    public String welcome(Model model) {
        model.addAttribute("title","Welcome");
        model.addAttribute("info","index");
        return "main_tmpl.html";
    }

    @GetMapping("/aboutme.html")
    public String aboutme(Model model) {
        model.addAttribute("title","About Me");
        model.addAttribute("info","aboutme");

        return "main_tmpl.html";
    }

    @GetMapping("/aboutcompany.html")
    public String aboutcompany(Model model) {
        model.addAttribute("title","About Company");
        model.addAttribute("info","aboutcompany");

        return "main_tmpl.html";
    }

    @GetMapping("/switches.html")
    public String switches(Model model) {
        model.addAttribute("title","Switches");
        model.addAttribute("info","switches");
        return "main_tmpl.html";
    }

}
