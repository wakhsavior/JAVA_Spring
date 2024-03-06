package ru.gb.MyRickAndMortyAPI.controllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.gb.MyRickAndMortyAPI.configs.APIResourses;
import ru.gb.MyRickAndMortyAPI.services.MainService;

import java.util.logging.Level;


@Controller
@RequestMapping()
@RequiredArgsConstructor
@Log
public class MainController {
    private final MainService mainService;
    private final APIResourses apiResourses;

    @GetMapping()
    public String getBaseURL(Model model){
        model.addAttribute("title","My Rick and Morty page");
        model.addAttribute("file_tmpl", "main_tmpl");
        model.addAttribute("content", "main");
        mainService.getAPIResourses();
        log.log(Level.INFO, apiResourses.toString());
        model.addAttribute("APIResourses", apiResourses);
        return "base_page_tmpl.html";
    }
}
