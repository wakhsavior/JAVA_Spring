package net.ddns.wakh.Java_Spring_Lecture_02;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("/")
    public String HelloController(){
        System.out.println("Send: \"Hello, spring boot!\"");
        return "Hello, spring boot!";
    }
}
