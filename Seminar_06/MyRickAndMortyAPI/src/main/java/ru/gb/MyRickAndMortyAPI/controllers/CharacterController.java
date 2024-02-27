package ru.gb.MyRickAndMortyAPI.controllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.gb.MyRickAndMortyAPI.configs.ConfigCustomer;
import ru.gb.MyRickAndMortyAPI.configs.APIResourses;
import ru.gb.MyRickAndMortyAPI.model.Character;
import ru.gb.MyRickAndMortyAPI.model.Location;
import ru.gb.MyRickAndMortyAPI.model.Request;
import ru.gb.MyRickAndMortyAPI.services.CharacterService;
import ru.gb.MyRickAndMortyAPI.services.MainService;

import java.util.ArrayList;
import java.util.logging.Level;

@Controller
@RequestMapping("/characters")
@RequiredArgsConstructor
@Log
public class CharacterController {
    private final ConfigCustomer configCustomer;
    private final APIResourses apiResourses;
    private final CharacterService characterService;
    private final MainService mainService;
    @Autowired
    private Request<Character> request;

    private void executeBaseParamForPage(Model model, String title, String fileName, String content) {
        model.addAttribute("title", title);
        model.addAttribute("file_tmpl", fileName);
        model.addAttribute("content", content);
        if (apiResourses.getCharacters() == null) {
            mainService.getAPIResourses();
        }
    }

    @GetMapping({"","/"})
    public String showAllCharacters(Model model) {
        executeBaseParamForPage(model, "My Rick and Morty Characters page", "characters_tmpl", "characters");

        log.log(Level.INFO, apiResourses.toString());

        log.log(Level.INFO, "Characters " + characterService.getAllCharacters().getResults());
        log.log(Level.INFO, "Page info " + characterService.getAllCharacters().getInfo());
//        System.out.println(characterService.getAllCharacters().getInfo().getCount());
//        System.out.println(characterService.getAllCharacters().getResults().getFirst());
        request = characterService.getAllCharacters();

        model.addAttribute("characters", request.getResults());
        model.addAttribute("pageinfo", request.getInfo());

        log.log(Level.INFO, "Open characters page with All Characters");
        model.addAttribute("APIResourses", apiResourses);
        return "base_page_tmpl.html";
    }

    @GetMapping("/{id}")
    public String showCharacterbyId(Model model, @PathVariable("id") int id) {
        executeBaseParamForPage(model, "My Rick and Morty Character", "characters_tmpl", "character");
        log.log(Level.INFO, apiResourses.toString());
        model.addAttribute("character", characterService.getCharacterById(id));
        return "base_page_tmpl.html";
    }
    @GetMapping("/next")
    public String showNextPage(Model model){
        executeBaseParamForPage(model, "My Rick and Morty Characters page", "characters_tmpl", "characters");
        if (request.getInfo().getNext()!=null){
            request = characterService.getCharacterPage(request.getInfo().getNext());
        }
        log.log(Level.INFO, "Characters " + characterService.getAllCharacters().getResults());
        log.log(Level.INFO, "Page info " + characterService.getAllCharacters().getInfo());
        model.addAttribute("characters", request.getResults());
        model.addAttribute("pageinfo", request.getInfo());

        return "base_page_tmpl.html";

    }
    @GetMapping("/previous")
    public String showPreviousPage(Model model){
        executeBaseParamForPage(model, "My Rick and Morty Characters page", "characters_tmpl", "characters");
        if (request.getInfo().getPrev()!=null){
            request = characterService.getCharacterPage(request.getInfo().getPrev());
        }
        log.log(Level.INFO, "Characters " + characterService.getAllCharacters().getResults());
        log.log(Level.INFO, "Page info " + characterService.getAllCharacters().getInfo());
        model.addAttribute("characters", request.getResults());
        model.addAttribute("pageinfo", request.getInfo());
        return "base_page_tmpl.html";

    }
}
