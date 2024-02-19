package net.ddns.wak.Task2.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Random;

/**
 * Через передачу параметров random?min=10&max=80
 */
@Controller
public class RandomController {
    @GetMapping("/random")
    public String rndPage(@RequestParam(name = "min") int min,
                          @RequestParam(name = "max") int max, Model model) {
        int randomInt = new Random().nextInt(min, max + 1);

        model.addAttribute("number", randomInt);
        model.addAttribute("min", min);
        model.addAttribute("max", max);
        return "random";
    }

    /**
     * Передачу параметров через путь. /random/{min}/{max}
     *
     * @return
     */
    @GetMapping("/random/{min}-{max}")
    public String pathRngPage(@PathVariable(name = "min") int min,
                              @PathVariable(name = "max") int max,
                              Model model){
        int randomInt = new Random().nextInt(min, max + 1);

        model.addAttribute("number", randomInt);
        model.addAttribute("min", min);
        model.addAttribute("max", max);
        return "random";
    }

}
