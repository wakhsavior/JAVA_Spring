package net.ddns.wakh.HomeWork.controllers;

import lombok.AllArgsConstructor;
import net.ddns.wakh.HomeWork.domain.User;
import net.ddns.wakh.HomeWork.services.DataProcessingService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/tasks")
@AllArgsConstructor
public class TaskController {
    DataProcessingService dataProcessingService;

    @GetMapping("/sort")
    public List<User> sortUser() {
        return dataProcessingService.sortUserByName();
    }
    @GetMapping("/filter/{min}/{max}")
    public List<User> sortUser(@PathVariable int min, @PathVariable int max){
        return dataProcessingService.filterUserByAge(min,max);
    }
    @GetMapping("/calc")
    public double calculateAveUserAge(){
        return dataProcessingService.calculateAverageAge();
    }
}
