package ru.gb.MyRickAndMortyAPI.controllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Level;

@Controller
@RequiredArgsConstructor
@Log
@RequestMapping("/episodes")
public class EpisodeController {
    @GetMapping({"", "/"})
    public String showAllEpisodes(Model model) {
        model.addAttribute("title", "Under Construction");
        model.addAttribute("file_tmpl", "under_construction_tmpl");
        model.addAttribute("content", "underconstruction");
        log.log(Level.INFO, "Request UNDER CONSTRUCTION PAGE");
        return "base_page_tmpl.html";
    }
}
