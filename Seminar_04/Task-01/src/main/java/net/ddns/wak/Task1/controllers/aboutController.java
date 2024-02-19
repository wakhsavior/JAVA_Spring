package net.ddns.wak.Task1.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller

public class aboutController {
@GetMapping("/about")
    public String about(){
    return "about.html";
}
}
