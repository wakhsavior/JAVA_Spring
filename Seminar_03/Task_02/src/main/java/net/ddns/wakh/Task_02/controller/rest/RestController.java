package net.ddns.wakh.Task_02.controller.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@org.springframework.web.bind.annotation.RestController
public class RestController {
    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }
    @GetMapping("/ciao")
    public String ciao(){
        return "ciao";
    }
    @PostMapping("/ciao")
    public String ciaoPOST(){
        return "ciao";
    }
}
